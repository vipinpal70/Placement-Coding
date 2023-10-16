import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import java.nio.file.attribute.UserPrincipal;
public class user {
    
    public static void main(String[] args) throws Exception {
        
        Path path = Paths.get("Doc1.docx");
        UserPrincipal owner = Files.getOwner(path);
        System.out.println("File owner: " + owner.getName());
    }
}
