package material.tree;

import java.io.*;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by David R on 06/06/2016.
 */
public class GameOfThrones {

    private static List<LinkedTree<FamilyMember>> treeList = new ArrayList<>(); //array de ARBOLES de las familias


    private class FamilyMember {
        private String id;
        private String name;
        private String surname;
        private String gender;
        private int age;


        public FamilyMember(String id, String name, String surname, String gender, int age) {
            this.id = id;
            this.surname = surname;
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public FamilyMember() {
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }



    public void loadFile(String pathToFile) throws FileNotFoundException, IOException {

        File file = new File(pathToFile); //Archivo
        Scanner sc = new Scanner(file);

        FamilyMember newPerson;//para añadir nuevas personas
        ArrayList<FamilyMember> peopleList = new ArrayList<>();//arrayList de familiares, personas
        ArrayList<String> FamilyHeadsList = new ArrayList<>();//ArrayList con los codigos de los cabeza de familia
        ArrayList<String> RelationsList = new ArrayList<>(); //ArrayList con las relacionse Padre->hijo
        Integer numHeads;

        while(sc.hasNext()) { // Probar con a ver sc.hasNextLine()

            LinkedTree<FamilyMember> treeHeads = new LinkedTree<>(); //arbol nuevo que se metera en el array listaRaices


            String linea = sc.nextLine(); //guarda en linea la linea que se lee en cada momento
            String[] lineaDividida = linea.split(" "); //crea un array con las pabras de la linea anterior, porque hacemos splite con espacios

            if (linea.contains(" = ")){

                String id = lineaDividida[0];
                System.out.println("id: "+ id);
                String name = lineaDividida[2];
                System.out.println("name: "+ name);
                String surname = lineaDividida[3];
                System.out.println("surname: "+ surname);
                String gender = lineaDividida[4];
                System.out.println("gender: "+ gender);
                Integer age = Integer.valueOf(lineaDividida[5]);
                System.out.println("age: "+ age);

                newPerson  = new FamilyMember(id,name,surname,gender, age);
                peopleList.add(newPerson);


            }
            else if (linea.contains("----")){
                String LineaNumFamilias = sc.nextLine();
                System.out.println("------------------------------");
                //System.out.println("num Familias: "+LineaNumFamilias);
                numHeads = Integer.valueOf(LineaNumFamilias);
                System.out.println("num Familias: "+numHeads);
            }
            else if(lineaDividida.length == 1){
                String cabeza = lineaDividida[0];
                FamilyHeadsList.add(cabeza);
                System.out.println("Cabeza de familia: "+cabeza);

            }
            else if (lineaDividida.length == 3){

                String lineaRelacion = linea;
                RelationsList.add(lineaRelacion);

                String padre = lineaDividida[0];
                String hijo = lineaDividida[2];

                System.out.println("linearelacion: "+lineaRelacion);
                System.out.println("Padre: "+padre);
                System.out.println("Hijo: "+hijo);

            }

        }

        sc.close();

        //tenemos una lista con todas las personas, una lista de cabezas y una lista de relaciones.
        System.out.println(" ........");
        System.out.println("Longitud de la ista de cabezas: "+FamilyHeadsList.size());
        System.out.println("Cantidad de gente: "+peopleList.size());
    }

    public FamilyMember getPersonById (ArrayList<FamilyMember> arrayDePersonas, String id) {

        for ( FamilyMember member: arrayDePersonas){
            if (member.getId().equals(id)){
                return member;
            }
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        GameOfThrones got = new GameOfThrones();
        got.loadFile("C:\\Users\\David R\\IdeaProjects\\EDA\\src\\got_edited.txt");
    }
}
