package api_endpoints;
/*Create user (Post)="https://petstore.swagger.io/v2/user"
 * Get user (Get)="https://petstore.swagger.io/v2/user/{}"
 * Update (Put)="https://petstore.swagger.io/v2/user/updateUser"
 * Delete (Delete)="https://petstore.swagger.io/v2/user/deleteUser"
 * 
 * */
public class Routes 
{
 public static String base_url="https://petstore.swagger.io/v2";
 public static String post_url=base_url+"/user";
 public static String get_url=base_url+"/user/{username}";
 public static String update_url=base_url+"/user/{username}";
 public static String delete_url=base_url+"/user/{username}";
}
