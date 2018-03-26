import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BasicListener extends ListenerAdapter{ //controls basic basic
    static ArrayList<Guild> permissionServers = new ArrayList<Guild>();//where private functions are enabled
    static ArrayList<String> ignoreList = new ArrayList<String>(); //users who have lost their bot privileges
    static String ignoreListLocation;
    static String BOT;
    static String OWNER = "Penguinpyromaniac";
    static String COMMAND;
    static ArrayList<String> storage = new ArrayList<String>();


    static public void persist(String file, ArrayList<String> list)
    {
        try
        {
            FileOutputStream fileOut =
                new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in %s!%n", file);
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    static public void read(String file)
    {
        System.out.printf("Loading previous session...%n");
        try
        {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<String> output = (ArrayList<String>) in.readObject();
            storage = output;
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
            System.out.printf("File not found! D:");
            c.printStackTrace();
        }
    }

    static public void ignore(MessageReceivedEvent event)
    {
        List<User> mentionedUsers = event.getMessage().getMentionedUsers();
        MessageChannel channel = event.getChannel();
        if (mentionedUsers.isEmpty())
        {
            channel.sendMessage("You need to provide users to ignore!").queue();
        }
        else
        {
            for (User user : mentionedUsers)
            {
                if (user.getId().equals("231242641801478145"))
                {
                    channel.sendMessage("Stop banning yourself, stop banning yourself!").queue();
                }
                else if (user.isBot())
                {
                    channel.sendMessage("Already ignoring other bots.").queue();
                }
                else if (!ignoreList.contains(user.getId()))
                {
                    ignoreList.add(user.getId());
                    persist(ignoreListLocation, ignoreList);
                    channel.sendMessage(user.getName() + " is now being ignored by " + BOT +"!").queue();
                }
                else
                {
                    channel.sendMessage(user.getName() + " is already being ignored!").queue();
                }

            }
        }
    }

    public static boolean auth(MessageReceivedEvent event) //authenticates
    {
        boolean result = false;
        result = event.getAuthor().getId().equals("231242641801478145");
        if (!result)
        {
            event.getChannel().sendMessage("sorry, only my owner may do that").queue();
        }
        return result;
    }

    public static void unignore(MessageReceivedEvent event)
    {
        List<User> mentionedUsers = event.getMessage().getMentionedUsers();
        MessageChannel channel = event.getChannel();
        if (mentionedUsers.isEmpty())
        {
            channel.sendMessage("You need to provide users to unignore!").queue();
        }
        else
        {
            for (User user : mentionedUsers)
            {
                if (ignoreList.contains(user.getId()))
                {
                    ignoreList.remove(user.getId());
                    channel.sendMessage(user.getName() + " no longer being ignored by " + BOT +"!").queue();
                }
                else
                {
                    channel.sendMessage(user.getName() + " is not being ignored!").queue();
                }

            }
        }
    }





}


