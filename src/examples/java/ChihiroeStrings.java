import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.File;

class ChihiroeStrings {
    static String credits = "Programming of CHIHiRoE by Penguinpyro. Avatar Drawn by Penguinpyro. "
        + "Based on API provided by DV8FromTheWorld, Kantenkugel and Frederikam: Java Discord API (JDA). "
        + "Inspiration taken from Keobot, by Keolah of Blackcobalt IRC #serriya." +
        "Mister Rogers Quotes from Fred Rogers.";

    static String factCheck(User author) {
        int random;
        String result = "I have no idea";
        if (author.getId().equals("231242641801478145")) {
            random = (int) (Math.random() * 3);
        } else {
            random = (int) (Math.random() * 10);
        }
        switch (random) {
            case (0):
                result = author + " is absolutely correct!";
                break;
            case (1):
                result = author + "'s assertion checks out.";
                break;
            case (2):
                result = author + " makes a good point.";
                break;
            case (3):
                result = author + "is mostly accurate.";
                break;
            case (4):
                result = author + "'s claim cannot be verified.";
                break;
            case (5):
                result = author + " is likely to be mistaken.";
                break;
            case (6):
                result = author + "'s logic seems shaky.";
                break;
            case (7):
                result = author + " is clearly incorrect!";
                break;
            case (8):
                result = author + "is not even wrong.";
                break;
            case (9):
                result = author + " is not quite correct.";
                break;
        }

        return result;
    }

    static String rollDice(int number) {
        String result;
        int random = (int) (Math.random() * number);

        if (number < 2) {
            result = "That's not a valid number.";
        } else if (number == 2) {
            if (random == 0)
                result = "Flipping a coin... heads!";
            else
                result = "Flipping a coin... tails!";
        } else {
            result = "Rolling a d" + number + "... " + "rolled a " + random + "!";
            if (number == 20 && random == 20)
                result = result + " CRITICAL HIT!";
        }
        return result;
    }

    static String praiseRando() {
        int random = (int) (Math.random() * 8);
        String result = "Error:Rando could not be praised!";
        switch (random) {
            case (0):
                result = "Praise Rando!";
                break;
            case (1):
                result = "Praise be to Rando!";
                break;
            case (2):
                result = "Praise the Random Number Goddess!";
                break;
            case (3):
                result = "Thank you Rando!";
                break;
            case (4):
                result = "Praise Rando! Death to the Machine Lords!";
                break;
            case (5):
                result = "Praise Rando, the One True Generator!";
                break;
            case (6):
                result = "Praise Rando, the Random Number Goddess";
                break;
            case (7):
                result = "PRAISE RANDO!";
                break;
        }
        return result;
    }

    static String misterRogers() {
        int random = (int) (Math.random() * 17);
        String result = "no quote could be found.";
        switch (random) {
            case (0):
                result = "You know, I think everybody longs to be loved, and longs to know that he or she is lovable. And, consequently, the greatest thing that we can do is to help somebody know that they're loved and capable of loving.";
                break;
            case (1):
                result = "If only you could sense how important you are to the lives of those you meet; how important you can be to people you may never even dream of. There is something of yourself that you leave at every meeting with another person.";
                break;
            case (2):
                result = "Anything that’s human is mentionable, and anything that is mentionable can be more manageable. When we can talk about our feelings, they become less overwhelming, less upsetting, and less scary. The people we trust with that important talk can help us know that we are not alone.";
                break;
            case (3):
                result = "In times of stress, the best thing we can do for each other is to listen with our ears and our hearts and to be assured that our questions are just as important as our answers.!";
                break;
            case (4):
                result = "Forgiveness is a strange thing. It can sometimes be easier to forgive our enemies than our friends. It can be hardest of all to forgive people we love. Like all of life's important coping skills, the ability to forgive and the capacity to let go of resentments most likely take root very early in our lives.";
                break;
            case (5):
                result = "It's very dramatic when two people come together to work something out. It's easy to take a gun and annihilate your opposition, but what is really exciting to me is to see people with differing views come together and finally respect each other.";
                break;
            case (6):
                result = "Love and trust, in the space between what’s said and what’s heard in our life, can make all the difference in the world.";
                break;
            case (7):
                result = "When I was a boy and I would see scary things in the news, my mother would say to me, 'Look for the helpers. You will always find people who are helping.' To this day, especially in times of 'disaster,' I remember my mother's words, and I am always comforted by realizing that there are still so many helpers--so many caring people in this world.";
                break;
            case (8):
                result = "There is no normal life that is free of pain. It's the very wrestling with our problems that can be the impetus for our growth.";
                break;
            case (9):
                result = "As human beings, our job in life is to help people realize how rare and valuable each one of us really is, that each of us has something that no one else has--or ever will have--something inside that is unique to all time. It's our job to encourage each other to discover that uniqueness and to provide ways of developing its expression.";
                break;
            case (10):
                result = "You make each day a special day. You know how, by just your being you. There's only one person in this whole world like you. And people can like you exactly as you are.";
                break;
            case (11):
                result = "My whole approach in broadcasting has always been \"You are an important person just the way you are. You can make healthy decisions. Maybe I'm going on too long, but I just feel that anything that allows a person to be more active in the control of his or her life, in a healthy way, is important.";
                break;
            case (12):
                result = "You know, I think everybody longs to be loved, and longs to know that he or she is lovable. And, consequently, the greatest thing that we can do is to help somebody know that they’re loved and capable of loving.";
                break;
            case (13):
                result = "The greatest gift you ever give is your honest self.";
                break;
            case (14):
                result = "You rarely have time for everything you want in this life, so you need to make choices. And hopefully your choices can come from a deep sense of who you are.";
                break;
            case (15):
                result = "There are three ways to ultimate success: The first way is to be kind. The second way is to be kind. The third way is to be kind.";
                break;
            case (16):
                result = "It’s a mistake to think that we have to be lovely to be loved by human beings or by God.";
                break;
        }
        return result;
    }

    static String search() {
        int rand = (int) (Math.random() * 21);
        switch (rand) {
            case 0:
            case 1:
            case 2:
                return "You search and find nothing.";
            case 3:
                return "You search and find a knife.";
            case 4:
                return "You search and find a fire axe.";
            case 5:
                return "You search and find a flare gun.";
            case 6:
                return "You search and find Waldo.";
            case 7:
                return "You search and find a pistol clip.";
            case 8:
                return "You search and find a pistol.";
            case 9:
                return "You search and find the Buddha on the road. You kill it.";
            case 10:
                return "You search and find a first aid kit.";
            case 11:
                return "You search and find a pair of binoculars.";
            case 12:
                return "You search and find a toolkit.";
            case 13:
                return "You search and find a lovely pair of coconuts.";
            case 14:
                return "You search and find a fuel can.";
            case 15:
                return "You search and find a shotgun.";
            case 16:
                return "You search and find a shotgun shell.";
            case 17:
                return "You search and find a syringe. Not the revivification kind, the recreational kind.";
            case 18:
                return "You search and find a DNA Extractor.";
            case 19:
                return "You search and find a crowbar.";
            case 20:
                return "You search and find some tinsel.";
        }
        return null;
    }

    static void elvis() {



    }

}

