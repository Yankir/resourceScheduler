package Controllers;

import Models.Resource;

import java.util.ArrayList;

public class ResourceController extends Resource
{
    private static ArrayList<Resource> resourceList = new ArrayList<>();
    private static int listSize = 0;

    private FileController<Resource> file = new FileController<>();

    public void list()
    {
        if(listSize == 0)
            System.out.println("\nLista vazia!");
        else
        {
            System.out.println();
            for(int i = 0 ; i < listSize ; i++)
            {
                System.out.println("Id: " + (i+1) + " | " + "Recurso: " + resourceList.get(i).getName() + " | " + "Descricao: " + resourceList.get(i).getDescription());
            }
        }
    }

    public void add(String name, String description)
    {
        resourceList.add(new Resource(name, description));
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
            resourceList.remove(position);
            listSize--;

            System.out.println("Recurso removido.\n");
        }
    }

    //checa se usuario existe na lista
    public boolean invalidId(int id)
    {
        return id < 1 || id > listSize;
    }

    //salva lista em um arquivo
    public void setResources()
    {
        if(listSize == 0)
        {
            System.out.println("Lista de recursos esta vazia!");
            return;
        }

        file.setFile("Resources",resourceList);
    }

    //le lista de um arquivo
    public void getResources()
    {
        resourceList = file.getFile("Resources");
        listSize = resourceList.size();
    }
}
