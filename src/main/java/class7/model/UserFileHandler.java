package class7.model;


import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class UserFileHandler {
    private static final String FILE_NAME = "Users.txt";

    // 读取登录的用户权限信息
    public static List<User> readUsers() {
        // 使用泛型
        List<User> users = new ArrayList<>();
        // try-catch...
        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/"+FILE_NAME))){
            String line; // 以行为单位读出
            while((line = reader.readLine())!= null){
                String[] fields = line.split(","); //以逗号为分割
                User user = new User(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        fields[2],
                        Boolean.parseBoolean(fields[3])
                );
                users.add(user);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return users;
    }

    /**
     * 方法：写入User信息到文件*/
    public static void writeUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + FILE_NAME))) {
            for (User user : users) {
                writer.write(String.format("%d,%s,%s,%b",
                        user.getId(),
                        user.getName(),
                        user.getPassword(),
                        user.isAdmin()));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
