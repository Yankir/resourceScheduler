package Controllers;

import java.io.*;
import java.util.ArrayList;

class FileController <Object>
{
    //salva lista de objeto generico Object em um arquivo
    void setFile(String fileName , ArrayList<Object> list)
    {
        try
        {
            FileOutputStream file = new FileOutputStream(fileName + ".dat");
            ObjectOutputStream out = new ObjectOutputStream(file);

            //escreve cada objeto no arquivo
            for(Object obj : list)
            {
                out.writeObject(obj);
                out.flush();
            }
            out.close();

            switch(fileName)
            {
                case "Users":
                    System.out.println("Lista de usuarios salva.");
                    break;
                case "Resources":
                    System.out.println("Lista de recursos salva.");
                    break;
                case "Schedules":
                    System.out.println("Lista de agendamentos salva.\n");
                    break;
                default:
                    System.out.println("Objeto nao encontrado!\n");
            }
        }
        catch(IOException exc)
        {
            switch(fileName)
            {
                case "Users":
                    System.out.println("Erro ao salvar usuarios!");
                    break;
                case "Resources":
                    System.out.println("Erro ao salvar recursos!");
                    break;
                case "Schedules":
                    System.out.println("Erro ao salvar agendamentos!\n");
                    break;
                default:
                    System.out.println("Erro ao salvar arquivo!\n");
            }
        }
    }

    //le lista de objeto generico Object de um arquivo
    ArrayList<Object> getFile(String fileName)
    {
        ArrayList<Object> obj = new ArrayList<>();

        try
        {
            FileInputStream file = new FileInputStream(fileName + ".dat");
            ObjectInputStream in = new ObjectInputStream(file);

            //le os objetos ate achar EOF
            while(true)
            {
                try
                {
                    obj.add((Object) in.readObject());
                }
                catch(EOFException e)
                {
                    break;
                }
            }
            in.close();

            switch(fileName)
            {
                case "Users":
                    System.out.println("Lista de usuarios lida.");
                    break;
                case "Resources":
                    System.out.println("Lista de recursos lida.");
                    break;
                case "Schedules":
                    System.out.println("Lista de agendamentos lida.\n");
                    break;
                default:
                    System.out.println("Objeto nao encontrado!\n");
            }
            return obj;
        }
        catch(IOException exc2)
        {
            switch(fileName)
            {
                case "Users":
                    System.out.println("Erro ao ler usuarios, verifique se o arquivo existe!");
                    break;
                case "Resources":
                    System.out.println("Erro ao ler recursos, verifique se o arquivo existe!");
                    break;
                case "Schedules":
                    System.out.println("Erro ao ler agendamentos, verifique se o arquivo existe!\n");
                    break;
                default:
                    System.out.println("Erro ao ler o arquivo, verifique se ele existe!\n");
            }
        }
        catch(ClassNotFoundException cnfex)
        {
            switch(fileName)
            {
                case "Users":
                    System.out.println("Classe de usuarios nao encontrada!");
                    break;
                case "Resources":
                    System.out.println("Classe de recursos nao encontrada!");
                    break;
                case "Schedules":
                    System.out.println("Classe de agendamentos nao encontrada!\n");
                    break;
                default:
                    System.out.println("Classe nao encontrada!\n");
            }
        }

        return obj;
    }
}
