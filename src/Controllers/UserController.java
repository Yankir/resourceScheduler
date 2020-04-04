package Controllers;

import Models.User;

import java.util.ArrayList;

public class UserController extends User
{
    private static ArrayList<User> userList = new ArrayList<>();
    private static int listSize = 0;

    //comunica com a controladora de arquivos
    private FileController<User> file = new FileController<>();

    public void list()
    {
        if(listSize == 0)
            System.out.println("\nLista vazia!");
        else
        {
            System.out.println();
            for(int i = 0 ; i < listSize ; i++)
            {
                System.out.println("Id: " + (i+1) + " | " + "Usuario: " + userList.get(i).getName() + " | " + "Email: " + userList.get(i).getEmail());
            }
        }
    }

    public void add(String name, String email)
    {
        userList.add(new User(name, email));
        listSize++;
    }

    public void remove(int position)
    {
        if(listSize == 0)
            System.out.println("Lista vazia!\n");
        else if(position < 0 || position >= listSize)
            System.out.println("Posicao inexistente!\n");
        else
        {
            userList.remove(position);
            listSize--;

            System.out.println("Usuario removido.\n");
        }
    }

    //checa se usuario existe na lista
    public boolean invalidId(int id)
    {
        return id < 1 || id > listSize;
    }

    //salva lista em um arquivo
    public void setUsers()
    {
        if(listSize == 0)
        {
            System.out.println("Lista de usuarios esta vazia!");
            return;
        }

        file.setFile("Users",userList);
    }

    //le lista de um arquivo
    public void getUsers()
    {
        userList = file.getFile("Users");
        listSize = userList.size();
    }
}
