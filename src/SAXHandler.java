
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Vector;


/**
 * Created by sadiq on 5/14/2017.
 */


class SAXHandler extends DefaultHandler {

    int progress;
    int totalRow;
    int currentRow;
    String d;
    SAXHandler(int totalrow)
    {
        progress=0;
        totalRow=totalrow;
        currentRow=0;
    }

    @Override
    //Triggered when the start of tag is found.
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        switch(qName){

            case "row":

                Vector<String> temp=new Vector<>();
                for(int i = 0; i< Object.list.size(); i++){
                    temp.add(attributes.getValue(Object.list.get(i)));
                }


                //i have created a table post2 in demo keyspace;
                //i can manually insert into the table but problem with parsing from file and then inserting it


              /* Connect.session.execute("INSERT INTO demo.posts2 " +
                        "(Id, PostTypeId,AcceptedAnswerId,Score,ViewCount,OwnerUserId,Title,Tags,AnswerCount,CommentCount)" +
                        " VALUES" +
                        "("+temp.get(0) + "," + temp.get(1)+ "," + temp.get(2)+ ","+ temp.get(4)+
                        ","+ temp.get(5) + "," + temp.get(6)+ ","  + temp.get(7) + "," + temp.get(8) +","+temp.get(9)+ ","+temp.get(10)+")");*/

              //Manual insert//
                //its working fine//
                Connect.session.execute("INSERT INTO demo.posts2 " +
                        "(Id, PostTypeId,AcceptedAnswerId,Score,ViewCount,OwnerUserId," +
                        "Title,Tags,AnswerCount,CommentCount) VALUES " +
                        "('a',10,100,10,54,5545,'g','h',4545,4545)");






               /* for(int i=0;i<temp.size();i++)
                {
                    System.out.println(Object.list.get(i)+" : "+temp.get(i));
                }*/

                //show the progress.needed because i have to know when finished.
                currentRow++;
                progress=(currentRow*100)/totalRow;
                System.out.println((progress+1) + "%");
                if(currentRow+10>=totalRow) System.out.println("Complete");
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        /*switch(qName){
            //Add the employee to list once end tag is found
            case "employee":
                empList.add(emp);
                break;
            //For all other end tags the employee has to be updated.
            case "firstName":
                emp.firstName = content;
                break;
            case "lastName":
                emp.lastName = content;
                break;
            case "location":
                emp.location = content;
                break;
        }*/
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
       /* content = String.copyValueOf(ch, start, length).trim();*/
    }

}