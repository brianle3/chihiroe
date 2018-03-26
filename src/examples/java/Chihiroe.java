import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Chihiroe extends BasicListener {
    File audioFile;
    static String ignoreListLocation = "C:/Users/bl/Documents/Elvis/ignoreList.ser";

    private boolean elvisLives = true;

    static {
        BOT = "CHIHiRoE";
        COMMAND = "!chi";
    }

    public static void main(String[] args) {
        try {
            JDA jda = new JDABuilder(AccountType.BOT)
                .setToken("MjQzNTMxMTY4NzY1NDQ0MDk5.DM3VIQ.onVpALvoLPUARGi9IRBTQ8VAZX4")           //The token of the account that is logging in.
                .addEventListener(new Chihiroe())  //An instance of a class that will handle events.
                .buildBlocking();  //There are 2 ways to login, blocking vs async. Blocking guarantees that JDA will be completely loaded.
            jda.getPresence().setGame(Game.of("Use '" + COMMAND + "' to activate me!"));
            //read(ignoreListLocation);

        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        String content = message.getContent();
        MessageChannel channel = event.getChannel();
        Guild guild = event.getGuild();
        User author = event.getAuthor();
        boolean bot = author.isBot();
        String[] command = content.split(" |\\,"); //tokenize spaces and commas

        if (ignoreList.contains(author) || bot) {
            return; //piss off, mate
        }

        if (content.startsWith("!ignore")) {
            List<User> mentionedUsers = message.getMentionedUsers();
            if (auth(event)) {
                ignore(event);
            }
        }

        if (content.startsWith("!unignore")) {
            if (auth(event)) {
                unignore(event);
            }
        }

        if (content.startsWith("!chi") || content.startsWith("!Chi")) {

            Message prompt = channel.sendMessage("Welcome " + author.getName() + " to CHIHiRoE! \n" +
                "Please click one of the buttons below to use this bot. \n" +
                " 0- Cancel selection. 1- Mister Rogers. 2- Fact Check Yourself. \n" +
                " 3- Random Pug Pictures. 4- Search for items. 5- Roll a Dice. \n" +
                "6- Praise Rando. 7- Mass Delete Your Messages. 8- Credits/About. \n" +
                "9- Random-ass Quotes" + "/:Microphone:- Elvis Mode- USE SPARINGLY.").complete();
            String id = prompt.getId();
            initialPrompt(prompt);
        }

        if (content.startsWith("!elvis")) {
            if (auth(event) && !elvisLives) {
                elvisLives = true;
                channel.sendMessage("The King has returned!").queue();
            } else if (auth(event)) {
                elvisLives = false;
                channel.sendMessage("Elvis has left the building!").queue();
            }
        }
    }


    public void initialPrompt(Message message) {
        //numbers one to ten
        message.addReaction("1⃣").queue();
        message.addReaction("2⃣").queue();
        message.addReaction("3⃣").queue();
        message.addReaction("4⃣").queue();
        message.addReaction("5⃣").queue();
        message.addReaction("6⃣").queue();
        message.addReaction("7⃣").queue();
        message.addReaction("8⃣").queue();
        message.addReaction("9⃣").queue();
        message.addReaction("0⃣").queue();
        message.addReaction("\uD83C\uDFA4").queue();


        //WAIT, timeout after 30 sec
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event)  {
        String emote = event.getReaction().toString();

        MessageChannel channel = event.getChannel();
        if (!event.getUser().getId().equals( "243531168765444099")) {
            switch (emote) {
                case ("1⃣"):
                    channel.sendMessage(ChihiroeStrings.misterRogers()).queue();
                    break;
                case ("2⃣"):
                    channel.sendMessage(ChihiroeStrings.factCheck(event.getUser())).queue();
                    break;
                case ("3⃣"):
                    int pug = (int) (Math.random() * 5);
                    File pugPic = new File("C:/Users/bl/Documents/Elvis/pug" + pug + ".jpg");
                    channel.sendFile(pugPic, null).queue();
                    break;
                case ("4⃣"):
                    channel.sendMessage(ChihiroeStrings.search()).queue();
                    break;
                case ("5⃣"):
                    //TODO
                    break;
                case ("6⃣"):
                    channel.sendMessage("Praising Rando...! Please wait!....").queue();
                    channel.sendMessage(ChihiroeStrings.praiseRando()).queue();
                    channel.sendMessage("Praising Rando complete!").queue();
                    break;
                case ("7⃣"):
                    break;
                case ("8⃣"):
                    channel.sendMessage(ChihiroeStrings.credits).queue();
                    break;
                case ("9⃣"):
                    break;
                case ("0⃣"):
                    break;
                case ("\uD83C\uDFA4"):
                    ChihiroeStrings.elvis();
                    break;
            }
        }


    }


}
