import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
//call from Subject Class
public class LogOnGoogleSheet extends Observer{
    public void update(String username,Object detail,String result){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM-dd-yyyy hh:mm:ss a");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println(formattedDate+username+detail+result);
        Object data[] = {formattedDate, username, detail ,result};
        List<List<Object>> values = Arrays.asList(Arrays.asList(data));
    }

}