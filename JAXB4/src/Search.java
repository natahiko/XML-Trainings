import java.io.*;
import java.util.*;
import javax.xml.bind.*;

import generated.*; //Generated classes

public class Search {

    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Register.class);
            Unmarshaller u = jc.createUnmarshaller();
            Register ktl = (Register) u.unmarshal(new FileInputStream("valid-husbands.xml"));
            List<Husband> husbands = ktl.getHusband();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name: ");
            String husbandName = sc.nextLine();

            for (int i = 0; i < husbands.size(); i++) {
                List<JAXBElement<?>> husband = husbands.get(i).getContent();

                if (husband.get(0).getValue().equals(husbandName)) {
                    for (int j = 0; j < husband.size(); j++) {
                        System.out.println(husband.get(j).getName().toString() + ": " + husband.get(j).getValue());
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
