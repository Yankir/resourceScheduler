package Controllers;

import Models.Schedule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ScheduleController extends Schedule
{
    private static ArrayList<Schedule> scheduleList = new ArrayList<>();
    private static int listSize = 0;

    private FileController<Schedule> file = new FileController<>();

    public void list()
    {
        if(listSize == 0)
            System.out.println("\nLista vazia!");
        else
        {
            System.out.println();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            for(int i = 0 ; i < listSize ; i++)
            {
                System.out.println("Id: " + (i+1) + " | " + "Id do usuario: " + scheduleList.get(i).getUserId() + " | "
                + "Id do recurso: " + scheduleList.get(i).getResourceId() + " | " + "Data/hora de inicio: " +
                formatter.format(scheduleList.get(i).getInitialDate()) + " | " + "Data/hora de fim: " +
                formatter.format(scheduleList.get(i).getFinalDate()));
            }
        }
    }

    boolean withinRange(Date testDate , Date initialDate , Date finalDate) {
        return !(testDate.before(initialDate) || testDate.after(finalDate));
    }

    //antes de adicionar verifica se e possivel fazer o agendamento
    public void add(int userId , int resourceId , Date initialDate , Date finalDate)
    {
        //percorre a lista para achar se recurso ja esta sendo utilizado nesse horario
        for(int i = 0 ; i < listSize ; i++)
        {
            //procura se o recurso esta agendado no horario pedido
            if(resourceId == scheduleList.get(i).getResourceId())
            {
                if((withinRange(initialDate,scheduleList.get(i).getInitialDate(),scheduleList.get(i).getFinalDate())) ||
                (withinRange(finalDate,scheduleList.get(i).getInitialDate(),scheduleList.get(i).getFinalDate())))
                {
                    System.out.println("\nRecurso indisponivel nesse horario!\n");
                    return;
                }
            }
        }

        scheduleList.add(new Schedule(userId,resourceId,initialDate,finalDate));
        listSize++;
        System.out.println("\nAgendamento adicionado.\n");
    }

    public void remove(int position)
    {
        if(listSize == 0)
            System.out.println("Lista vazia!\n");
        else if(position < 0 || position >= listSize)
            System.out.println("Posicao inexistente!\n");
        else
        {
            scheduleList.remove(position);
            listSize--;

            System.out.println("Agendamento removido.\n");
        }
    }

    //salva lista em um arquivo
    public void setSchedules()
    {
        if(listSize == 0)
        {
            System.out.println("Lista de agendamentos esta vazia!\n");
            return;
        }

        file.setFile("Schedules",scheduleList);
    }

    //le lista de um arquivo
    public void getSchedules()
    {
        scheduleList = file.getFile("Schedules");
        listSize = scheduleList.size();
    }
}
