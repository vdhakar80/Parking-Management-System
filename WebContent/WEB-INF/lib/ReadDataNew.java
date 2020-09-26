import java.io.*;

//import javax.comm.*;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.*;
import java.sql.*;
public class ReadDataNew implements Runnable, SerialPortEventListener {
    static CommPortIdentifier portId;


    InputStream inputStream;
    SerialPort serialPort;
    Thread readThread;
     String value=new String();




    public ReadDataNew(String name,String comPort) {


        try {
			portId = CommPortIdentifier.getPortIdentifier(comPort);
            serialPort = (SerialPort) portId.open(name, 2000);
            serialPort.setSerialPortParams(9600,
			                SerialPort.DATABITS_8,
			                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);


            inputStream = serialPort.getInputStream();

            serialPort.addEventListener(this);

        serialPort.notifyOnDataAvailable(true);


        } catch (Exception e) {System.out.println(e);}


        readThread = new Thread(this);
        readThread.start();
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {System.out.println(e);}


    }

    public void serialEvent(SerialPortEvent event) {
        switch(event.getEventType()) {

        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            break;
        case SerialPortEvent.DATA_AVAILABLE:
            byte[] readBuffer = new byte[12];

            try {

                 while (inputStream.available() > 0) {
                    int numBytes = inputStream.read(readBuffer);
                }
                value=new String(readBuffer);
String provider="jdbc:mysql://localhost:3308/parking";

		try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,"root",null);
		Statement smt=cn.createStatement();
		String query="Insert into rfid values('"+value.trim()+"')"; 			    smt.executeUpdate(query);
		System.out.println("Number Saved....");
		cn.close();
		 	 }catch(Exception e)
			 {System.out.println(e);
									 }
                 System.out.print("xxxxxxxxxxxxxx"+value);

            } catch (IOException e) {System.out.println(e);
            }
            break;
        }
    }
}