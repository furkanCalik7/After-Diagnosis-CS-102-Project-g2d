public class Code {

    String code_id;
    String doctor_username;
    boolean is_used;

    public Code(String code_id, String doctor_username, boolean is_used) {
        this.code_id = code_id;
        this.doctor_username = doctor_username;
        this.is_used = is_used;
    }
    public static Code newCode(String doctor_username){
        MySQLAccess mySQLAccess = new MySQLAccess();
        String code_index;
        StringBuffer code_id;
        char random;

        code_index = "abcdefghijklmnopqrstuvwxtz0123456789";
        code_id = new StringBuffer("");

        do{
            for(int i = 0; i < 6; i++){
                random = code_index.charAt((int)(Math.random()*36));
                code_id.append(random);
            }
        }while(mySQLAccess.isCodeUsed(code_index));
        return new Code(code_index, doctor_username,false);
    }

    public String getCode_id() {
        return code_id;
    }
}