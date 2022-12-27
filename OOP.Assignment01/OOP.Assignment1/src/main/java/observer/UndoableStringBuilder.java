package observer;

import java.util.Stack;

/*
Use the class you've implemented in previous assignment
 */
public class UndoableStringBuilder {

    StringBuilder data;
    Stack<String> list;

    public  UndoableStringBuilder ()
    {
        this.data=new StringBuilder();
        this.list=new Stack<String>();
    }

    /**
     * Appends the specified string to this character sequence.
     * @return the new string-the old string + str
     */
    public UndoableStringBuilder append(String str)
    {
        this.data.append(str);
        this.list.push(this.data.toString());
        return this;
    }
    /**
     * Removes the characters in a substring of this sequence.
     *If start is equal to end, no changes are made.

     * @return the new string-the old string with out the part we delete.
     */
    public UndoableStringBuilder delete(int start, int end)
    {

        try
        {
            if(start>end)return this;
            if(end>this.data.length())throw new IllegalArgumentException();
            this.data.delete(start, end);
            this.list.push(this.data.toString());
        }
        catch (StringIndexOutOfBoundsException e) {

            System.out.println("It is not possible to delete an index that does not exist");
        }
        catch (IllegalArgumentException e) {

            System.out.println("It is not possible to delete an index that does not exist");
        }
        return this;
    }

    /**
     *Inserts the string into this character sequence.
     *@return the insert
     */
    public UndoableStringBuilder insert(int offset, String str)
    {
        try {
            this.data.insert(offset, str);
            this.list.push(this.data.toString());
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("It is not possible to insert an index that does not exist");
        }
        return this;
    }
    /**
     * Replaces the characters in a substring of this sequence with characters in
     the specified String.
     @return the string after the replace
     */
    public UndoableStringBuilder replace(int start,int end, String str)
    {

        try
        {
            if(start>end) return this;
            this.data.replace(start, end, str);
            this.list.push(this.data.toString());
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("It is not possible to replace an index that does not exist");
        }
        catch (NullPointerException e) {
            System.out.println("It is not possible to replace an index with null");
        }




        return this;
    }
    /**
     *    Causes this character sequence to be replaced by the reverse of the sequence.
     *    @return the reverse string
     * */
    public UndoableStringBuilder reverse()
    {
        this.data.reverse();
        this.list.push(this.data.toString());
        return this;
    }


    /**
     * Cancels the last operation you performed on the string
     * @return the string that was before the last change
     * */
    public UndoableStringBuilder undo()
    {
        try {
            int length=this.list.peek().length();
            this.list.pop();
            this.data.replace(0,length , this.list.peek());		}

        catch (Exception e) {
            System.out.println("You have already canceled all the actions you performed");
        }
        return this;

    }
    /**
     * @return the current string
     * */
    @Override
    public String toString() {
        return this.data.toString();
    }



}
