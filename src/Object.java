import java.util.Vector;

/**
 * Created by sadiq on 5/14/2017.
 */
public class Object {
    public static Vector<String> list;
    Object(String name)
    {
        if(name=="Posts") {
            list = new Vector<>();
            list.add("Id");
            list.add("PostTypeId");
            list.add("AcceptedAnswerId");
            list.add("CreationDate");
            list.add("Score");
            list.add("ViewCount");
            //list.add("Body");
            list.add("OwnerUserId");
            list.add("Title");
            list.add("Tags");
            list.add("AnswerCount");
            list.add("CommentCount");
        }
    }
}
