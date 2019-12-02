/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Kendrick
 * This is for official communications purposes if there is someone who
 * has a problem with our application. This should contain contact information
 * of the one currently responsible for the project
 */
public class Support {
    private static final String HEAD_PROGRAMMER = "David Houman; Kendrick Michaud";
    private static final String HEAD_EMAIL = "david.houman.17@cnu.edu; kendrick.michaud.17@cnu.edu";
    private static final String HEAD_PHONE = "(703)-869-3425; (757)-706-2148";
    private static final String NEW_PARA = "<p>";
    private static final String END_PARA = "</p>";
    private static final String CONTACT_HEAD = 
            "Contact Developers";
    
    public static String getContactInformation(){
        StringBuilder sb = new StringBuilder("<html>");
        sb.append(NEW_PARA).append(CONTACT_HEAD).append(END_PARA);
        sb.append(NEW_PARA).append(HEAD_PROGRAMMER).append(END_PARA);
        sb.append(NEW_PARA).append(HEAD_EMAIL).append(END_PARA);
        sb.append(NEW_PARA).append(HEAD_PHONE).append(END_PARA);
        return sb.toString();
    }
}
