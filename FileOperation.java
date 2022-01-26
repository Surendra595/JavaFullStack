package Project;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperation {
    static String DIRECTORY;
    File folder_name;

    public FileOperation() {
        DIRECTORY = System.getProperty("user.dir");
        folder_name = new File(DIRECTORY+"/files");
        if (!folder_name.exists())
            folder_name.mkdirs();
        System.out.println("DIRECTORY : "+ folder_name.getAbsolutePath());
    }

    private static final String WELCOME_PROMPT =
            "\n*****************  LockerMe.com *******************"+
                    "\n***************** 2485226_Surendra *******************\n";

    private static final String MAIN_MENU_PROMPT =
            "\nMAIN MENU - Select any of the following: \n"+
                    "a -> List files in directory\n"+
                    "b -> Add, Delete or Search\n"+
                    "c -> Exit Program";

    private static final String SECONDARY_MENU_PROMPT =
            "   \nSelect any of the following: \n"+
                    "   1 -> Add a file\n"+
                    "   2 -> Delete a file\n"+
                    "   3 -> Search a file\n"+
                    "   4 -> GoBack";

    void showPrimaryMenu() {
        System.out.println(MAIN_MENU_PROMPT);
        try{
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option){
                case 1 : {
                    showFiles();
                    showPrimaryMenu();
                }
                case 2 : {
                    showSecondaryMenu();
                }
                case 3 : {
                    System.out.println("Thank You");
                    System.exit(0);
                }
                default: showPrimaryMenu();
            }
        }
        catch (Exception e){
            System.out.println("Enter 1, 2 or 3");
            showPrimaryMenu();
        }
    }

    void showSecondaryMenu() {
        System.out.println(SECONDARY_MENU_PROMPT);
        try{
            Scanner sc = new Scanner(System.in);
            char[] input = sc.nextLine().toLowerCase().trim().toCharArray();
            char option = input[0];

            switch (option){
                case '1' : {
                    System.out.print("↳ Adding a file...Please Enter a File Name : ");
                    String filename = sc.next().trim().toUpperCase();
                    addFile(filename);
                    break;
                }
                case '2' : {
                    System.out.print("↳ Deleting a file...Please Enter a File Name : ");
                    String filename = sc.next().trim();
                    deleteFile(filename);
                    break;
                }
                case '3' : {
                    System.out.print("↳ Search a file...Please Enter a File Name : ");
                    String filename = sc.next().trim();
                    searchFile(filename);
                    break;
                }
                case '4' : {
                    System.out.println("Back to MAIN menu");
                    showPrimaryMenu();
                    break;
                }
                default : System.out.println("Enter 1, 2, 3 or 4");
            }
            showSecondaryMenu();
        }
        catch (Exception e){
            System.out.println("Enter 1, 2, 3 or 4");
            showSecondaryMenu();
        }
    }

    void showFiles() {
        if (folder_name.list().length==0)
            System.out.println("The folder is empty");
        else {
            String[] list = folder_name.list();
            System.out.println("The files in "+ folder_name +" are :");
            Arrays.sort(list);
            for (String str:list) {
                System.out.println(str);
            }
        }
    }

    void addFile(String filename) throws IOException {
        File filepath = new File(folder_name +"/"+filename);
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equalsIgnoreCase(file)) {
                System.out.println("File " + filename + " already exists at " + folder_name);
                return;
            }
        }
        filepath.createNewFile();
        System.out.println("File "+filename+" added to "+ folder_name);
    }

    void deleteFile(String filename) {
        File filepath = new File(folder_name +"/"+filename);
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equals(file) && filepath.delete()) {
                System.out.println("File " + filename + " deleted from " + folder_name);
                return;
            }
        }
        System.out.println("Delete Operation failed. FILE NOT FOUND");
    }

    void searchFile(String filename) {
        String[] list = folder_name.list();
        for (String file: list) {
            if (filename.equals(file)) {
                System.out.println("FOUND : File " + filename + " exists in " + folder_name);
                return;
            }
        }
        System.out.println("File NOT found (FNF)");
    }

    public static void main(String[] args) {
        System.out.println(WELCOME_PROMPT);
        FileOperation menu = new FileOperation();
        menu.showPrimaryMenu();
    }
}
