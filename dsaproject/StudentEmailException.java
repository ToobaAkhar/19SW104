/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaproject;
public class StudentEmailException extends Exception
{

   public StudentEmailException ()
   {
      super ();
   }

   public StudentEmailException (String message)
   {
      super (message);
   }

   public StudentEmailException (Throwable cause)
   {
      super (cause);
   }

   public StudentEmailException (String message, Throwable cause)
   {
      super (message, cause);
   }
}