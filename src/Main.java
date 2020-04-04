import Controllers.*;
import View.Menus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        boolean run = true;

        while(run)
        {
        	Menus menu = new Menus();
            menu.mainMenu();
            String option = input.nextLine();
            System.out.println();

            //criando as controladoras
            UserController userCtrl = new UserController();
            ResourceController resourceCtrl = new ResourceController();
            ScheduleController scheduleCtrl = new ScheduleController();

            //variavel para printar o submenu novamente
            boolean reprint = true;
            boolean invalidInt = false;

            switch(option)
            {
                //usuarios
                case "1":
                    while(reprint)
                    {
                        menu.userMenu();
                        menu.subMenu();
                        option = input.nextLine();

                        switch (option) {
                            case "1":
                                userCtrl.list();

                                System.out.println("\nPressione enter para voltar ao menu de usuarios.");
                                input.nextLine();
                                break;

                            case "2":
                                System.out.print("\nDigite o nome: ");
                                String name = input.nextLine();
                                System.out.print("Digite o email: ");
                                String email = input.nextLine();
                                System.out.println();

                                userCtrl.add(name,email);
                                System.out.println("Usuario adicionado.\n");
                                break;

                            case "3":
                                int id = 0;

                                do
                                {
                                    try
                                    {
                                        System.out.print("\nDigite o id do usuario: ");
                                        id = input.nextInt();
                                        input.nextLine();

                                        invalidInt = false;
                                    }
                                    catch (java.util.InputMismatchException ex)
                                    {
                                        System.out.println("Entrada invalida, digite novamente!");
                                        input.nextLine();
                                        invalidInt = true;
                                    }
                                }
                                while(invalidInt);
                                System.out.println();

                                userCtrl.remove(id - 1);
                                break;

                            case "4":
                                System.out.println();
                                reprint = false;
                                break;

                            default:
                                System.out.println("\nOpcao inexistente, digite novamente.\n");
                        }
                    }
                    break;
                    
                //recursos
                case "2":
                    while(reprint)
                    {
                        menu.resourceMenu();
                        menu.subMenu();
                        option = input.nextLine();

                        switch (option) {
                            case "1":
                                resourceCtrl.list();

                                System.out.println("\nPressione enter para voltar ao menu de recursos.");
                                input.nextLine();
                                break;

                            case "2":
                                System.out.print("\nDigite o nome: ");
                                String name = input.nextLine();
                                System.out.print("Digite a descricao: ");
                                String description = input.nextLine();
                                System.out.println();

                                resourceCtrl.add(name,description);
                                System.out.println("Recurso adicionado.\n");
                                break;

                            case "3":
                                int id = 0;

                                do
                                {
                                    try
                                    {
                                        System.out.print("\nDigite o id do recurso: ");
                                        id = input.nextInt();
                                        input.nextLine();

                                        invalidInt = false;
                                    }
                                    catch (java.util.InputMismatchException ex)
                                    {
                                        System.out.println("Entrada invalida, digite novamente!");
                                        input.nextLine();
                                        invalidInt = true;
                                    }
                                }
                                while(invalidInt);
                                System.out.println();

                                resourceCtrl.remove(id - 1);
                                break;

                            case "4":
                                System.out.println();
                                reprint = false;
                                break;

                            default:
                                System.out.println("\nOpcao inexistente, digite novamente.\n");
                        }
                    }
                    break;
                    
                //agendamentos
                case "3":
                    while(reprint)
                    {
                        menu.scheduleMenu();
                        menu.subMenu();
                        option = input.nextLine();

                        switch (option) {
                            case "1":
                                scheduleCtrl.list();

                                System.out.println("\nPressione enter para voltar ao menu de agendamentos.");
                                input.nextLine();
                                break;

                            case "2":
                                //checar se existe pelo menos 1 usuario
                                if(userCtrl.invalidId(1))
                                {
                                    System.out.println("Nao existem usuarios cadastrados!\n");
                                    break;
                                }

                                //checar se existe pelo menos 1 recurso
                                if(resourceCtrl.invalidId(1))
                                {
                                    System.out.println("Nao existem recursos cadastrados!\n");
                                    break;
                                }

                                int userId = 0;

                                do
                                {
                                    try
                                    {
                                        System.out.print("\nDigite o id do usuario: ");
                                        userId = input.nextInt();
                                        input.nextLine();

                                        //checar se o id existe
                                        invalidInt = userCtrl.invalidId(userId);
                                    }
                                    catch (java.util.InputMismatchException ex)
                                    {
                                        System.out.println("Entrada invalida, digite novamente!");
                                        input.nextLine();
                                        invalidInt = true;
                                    }
                                    finally
                                    {
                                        if(invalidInt)
                                            System.out.println("Entrada invalida, digite novamente!\n");
                                    }
                                }
                                while(invalidInt);

                                int resourceId = 0;
                                do
                                {
                                    try
                                    {
                                        System.out.print("Digite o id do recurso: ");
                                        resourceId = input.nextInt();
                                        input.nextLine();

                                        invalidInt = resourceCtrl.invalidId(resourceId);
                                    }
                                    catch (java.util.InputMismatchException ex)
                                    {
                                        input.nextLine();
                                        invalidInt = true;
                                    }
                                    finally
                                    {
                                        if(invalidInt)
                                            System.out.println("Entrada invalida, digite novamente!\n");
                                    }
                                }
                                while(invalidInt);

                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                simpleDateFormat.setLenient(false);

                                Date initialDate = null;
                                boolean invalidDate;

                                //inicio
                                do
                                {
                                    System.out.print("Digite a data e hora de inicio no formato \"dd/MM/yyyy HH:mm\": ");
                                    String initialDateString = input.nextLine();

                                    try
                                    {
                                        initialDate = simpleDateFormat.parse(initialDateString);
                                        invalidDate = false;
                                    }
                                    catch (ParseException ex)
                                    {
                                        System.out.print("Data invalida ou nao esta no formato correto, digite novamente.\n\n");
                                        invalidDate = true;
                                    }
                                }
                                while (invalidDate);

                                Date finalDate = null;

                                //fim
                                do
                                {
                                    System.out.print("Digite a data e hora de fim no formato \"dd/MM/yyyy HH:mm\": ");
                                    String initialDateString = input.nextLine();

                                    try
                                    {
                                        finalDate = simpleDateFormat.parse(initialDateString);
                                        invalidDate = false;
                                    }
                                    catch (ParseException ex)
                                    {
                                        System.out.println("Data invalida ou nao esta no formato correto.\n");
                                        invalidDate = true;
                                    }
                                }
                                while (invalidDate);

                                scheduleCtrl.add(userId,resourceId,initialDate,finalDate);
                                break;

                            case "3":
                                int id = 0;

                                do
                                {
                                    try
                                    {
                                        System.out.print("\nDigite o id a ser removido: ");
                                        id = input.nextInt();
                                        input.nextLine();

                                        invalidInt = false;
                                    }
                                    catch (java.util.InputMismatchException ex)
                                    {
                                        System.out.println("Entrada invalida, digite novamente!");
                                        input.nextLine();
                                        invalidInt = true;
                                    }
                                }
                                while(invalidInt);
                                System.out.println();

                                scheduleCtrl.remove(id - 1);
                                break;

                            case "4":
                                System.out.println();
                                reprint = false;
                                break;

                            default:
                                System.out.println("\nOpcao inexistente, digite novamente.\n");
                        }
                    }
                    break;
                    
                //salvar as 3 listas
                case "4":
                    userCtrl.setUsers();
                    resourceCtrl.setResources();
                    scheduleCtrl.setSchedules();
                    break;
                    
                //carregar as 3 listas
                case "5":
                    userCtrl.getUsers();
                    resourceCtrl.getResources();
                    scheduleCtrl.getSchedules();
                    break;
                    
                //sair
                case "6":
                    run = false;
                    break;
                    
                default:
                    System.out.println("\nOpcao inexistente, digite novamente.\n");
            }
        }
    }
}
