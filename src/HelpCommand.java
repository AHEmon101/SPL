public class HelpCommand {
    public static void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("1. showcurrentpath - Show current working directory");
        System.out.println("2. changepath <path> - Change current working directory to absolute path");
        System.out.println("3. createfile <file_name>");
        System.out.println("4. createdirectory <directory_name>");
        System.out.println("5. deletefile <file_name>");
        System.out.println("6. deletedirectory <directory_name>");
        System.out.println("7. renamefile <old_file_name> <new_file_name>");
        System.out.println("8. movefile <source_file> <destination_file>");
        System.out.println("9. copyfile <source_file> <destination_file>");
        System.out.println("10. listcontents <directory>");
        System.out.println("11. searchfiles <directory> [query]");
        System.out.println("12. viewfile <file_name>");
        System.out.println("13. editfile <file_name>");
        System.out.println("14. sortfiles <directory>");
        System.out.println("15. filterfiles <directory> <file_extension>");
        System.out.println("16.help");
        System.out.println("17.Tree");
        System.out.println("Type 'exit' to exit the File Manager.");
    }
}
