package View;

public class Menus
{
    public void mainMenu()
    {
        System.out.println("-----------------------Agendamento de recursos-----------------------");
        System.out.println("Escolha uma opcao:");
        System.out.println("1. Acessar usuarios");
        System.out.println("2. Acessar recursos");
        System.out.println("3. Acessar agendamentos");
        System.out.println("4. Salvar dados");
        System.out.println("5. Carregar dados");
        System.out.println("6. Sair");
    }

    public void subMenu()
    {
        System.out.println("1. Mostrar lista");
        System.out.println("2. Adicionar");
        System.out.println("3. Remover");
        System.out.println("4. Voltar");
    }

    public void userMenu() { System.out.println("------------------------------Usuarios-------------------------------"); }

    public void resourceMenu() { System.out.println("------------------------------Recursos-------------------------------"); }

    public void scheduleMenu() { System.out.println("----------------------------Agendamentos-----------------------------"); }
}
