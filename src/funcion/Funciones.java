package funcion;

public class Funciones {
    public static Double res;
    public static Double operar(char operador, Double n1, Double n2){
        Double result = null;
        if (operador == '+'){
            result = n1 + n2;
        } else if (operador == '-'){
            result = n1 - n2;
        } else if (operador == '*'){
            result = n1*n2;
        } else if (operador == '/'){
            result = n1/n2;
        } else if (operador == 'm'){
            result = n1%n2;
        }
        return result;
    }

    /*public static void sumar(){
        if (res == null && num1 == null){
            num1 = Double.parseDouble(FrmMain.barraTxt.getText());
            FrmMain.barraTxt.setText(null);
        } else if (res == null && num1 != null){
            res = Double.parseDouble(FrmMain.barraTxt.getText());
            res += num1;
            FrmMain.barraTxt.setText(res.toString());
            num1 = null;
        } else if (res != null && num1 == null){
            num1 = Double.parseDouble(FrmMain.barraTxt.getText());
            res += num1;
            FrmMain.barraTxt.setText(res.toString());
            num1 = null;
        }
    }

    public static void restar(){
        if (res == null && num1 == null){
            num1 = Double.parseDouble(FrmMain.barraTxt.getText());
            FrmMain.barraTxt.setText(null);
        } else if (res == null && num1 != null){
            res = -1.0*Double.parseDouble(FrmMain.barraTxt.getText());
            res = num1 + res;
            FrmMain.barraTxt.setText(res.toString());
            num1 = null;
        } else if (res != null && num1 == null){
            num1 = -1.0*Double.parseDouble(FrmMain.barraTxt.getText());
            res = num1 + res;
            FrmMain.barraTxt.setText(res.toString());
            num1 = null;
        }
    }*/
}
