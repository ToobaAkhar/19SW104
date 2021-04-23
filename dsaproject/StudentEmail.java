/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaproject;

public class StudentEmail
{
   public static final String EMAIL_STUB = "@my.email";

   private String name;
   private String id;
   private String number;
   private String cnic;
   private String city;

   public StudentEmail ()
   {
      name = "";
      id   = "";
      number ="";
      cnic="";
      city="";


   }

   public StudentEmail (String name, String id,String number,String cnic,String city)
   
                        throws StudentEmailException
   {
      // Remove elading and trailing spaces, tabs.
      name = name.trim ();
      id   = id.trim ();
      number = number.trim ();
      cnic = cnic.trim ();
      city = city.trim ();


      if (name.length () == 0)
      {
         //JOptionPane.showMessageDialog (null, "Error: name cannot be blank.");
         throw new StudentEmailException ("Error: name cannot be blank.");
      }

      else if (id.length () == 0)
      {
         //JOptionPane.showMessageDialog (null, "Error: Id cannot be blank.");
         throw new StudentEmailException ("Error: Id cannot be blank.");
      }

      else if (number.length () == 0)
      {
         //JOptionPane.showMessageDialog (null, "Error: Id cannot be blank.");
         throw new StudentEmailException ("Error: number cannot be blank.");
      }
       else if (cnic.length () == 0)
      {
         //JOptionPane.showMessageDialog (null, "Error: Id cannot be blank.");
         throw new StudentEmailException ("Error: cnic cannot be blank.");
      }
       else if (city.length () == 0)
      {
         //JOptionPane.showMessageDialog (null, "Error: Id cannot be blank.");
         throw new StudentEmailException ("Error: city cannot be blank.");
      }



      else
      {
         // All is OK, set class data to the values passed in.
         this.name = name;
         this.id   = id;
         this.number = number;
         this.cnic = cnic;
         this.city = city;
      }
   }

   public String getName ()
   {
      return name;
   }

   public String getId ()
   {
      return id;
   }
    public String getNumber ()
   {
      return number;
   }
   public String getCnic ()
   {
      return cnic;
   }
    public String getCity ()
   {
      return city;
   }

   public void setName (String name)
   {
      this.name = name;
   }

   public void setId (String id)
   {
      this.id = id;
   }
    public void setNumber (String Number)
   {
      this.number = number;
   }
   public void setCnic (String Number)
   {
      this.cnic = cnic;
   }
   public void setCity (String Number)
   {
      this.city = city;
   }


   @Override
   public String toString ()
   {
      return id + "\t" + name + "\t" + number + "\t " + cnic + "\t "+ city + "\t "+ id + EMAIL_STUB;
   }

} // public class StudentEmail
