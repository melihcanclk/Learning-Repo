import java.io.*;

public class GetDotEnvForDB {
    BufferedReader reader;
    private String url;
    private String username;
    private String password;
    GetDotEnvForDB(){
        try {
            reader = new BufferedReader(new FileReader(".env"));
            String line = reader.readLine();
            for(int i = 0; i < 3; i++){
                if(line != null){
                    if(i == 0){
                        url = line.substring(line.lastIndexOf("=" ) + 1);
                    }else if(i == 1){
                        username = line.substring(line.lastIndexOf("=" ) + 1);
                    }else{
                        password = line.substring(line.lastIndexOf("=" ) + 1);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
