package project_01;

import javax.swing.JOptionPane;

public class FidoPlays {
    static public void main (String[] args){
        int result=0,
            choice01=0,
            choice02=0,
            choice03=0,
            choice04=0,
            choice05=0;
        
        String title, intro, input, beat01, beat02, beat03, beat04, beat05,
        resultMessage=" ";
        title = "Fido Wants to Play!";
        
        intro = "<html><p style='text-align: center;'>Welcome to</p>" +
                       "<h1 style='text-align: center'>Fido Wants to Play!</h1>" +
                       "<p>A story quiz to see if you have the basic knowledge to care</p>" +
                       "<p>for some typical things a dog will do throughout its life.</p><br>" +
                       "<p>An important rule! Answer with only 1, 2, 3, or 4.</p>" +
                       "<p style='text-align: center;'>No pressure!</p><br>" +
                       "<p style='text-align: center;'>Alright, lets begin!</p></html>";
        JOptionPane.showMessageDialog(null, intro, title, JOptionPane.PLAIN_MESSAGE);

        beat01 = "<html><h1 style='text-align:center;'>Chapter 1: Fido Plays...<h1>" +
                        "<p>Fido wakes up on a beautiful morning; like any other.</p>" +
                        "<p>With a lazy yawn and a passionate stretch, Fido is ready</p>" +
                        "<p>to play! But what's safe for Fido to play with?</p><br><br>" +
                        "<p>Please pick a number for you choice:</p><br>" +
                        "<p>1. Snicker wrapper</p>" +
                        "<p>2. Random rock</p>" +
                        "<p>3. Random stick</p>" +
                        "<p>4. Chew toy</p>";
        input = JOptionPane.showInputDialog(null, 
            beat01, 
            title, JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d+")){
            choice01 = Integer.parseInt(input);
        } else {
            JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        switch (choice01) {
            case 1:
                JOptionPane.showMessageDialog(null, 
                        "Uh oh! That wrapper was hard to swallow!\n" +
                        "Gulp!\n" +
                        "Almost choked there...\n" +
                        "hope it heads south safely..." +
                        "\n\npoints: 0", title, JOptionPane.PLAIN_MESSAGE);
                result += 0;
                break;
        
            case 2:
                JOptionPane.showMessageDialog(null, 
                        "Ouch! That was fun...until my teeth hurt.\n" +
                        "But my teeth aren't punks! We'll see which is stronger\n" +
                        "if that's the last thing my teeth do!" +
                        "\n\npoints: 0", title, JOptionPane.PLAIN_MESSAGE);
                result += 0;
                break;
        
            case 3:
                JOptionPane.showMessageDialog(null, 
                        "Meh. Kind of chewy but it'll do...ouch!\n" +
                        "Gotta watch for splinters...does taste nice..." +
                        "\n\npoints: 2", title, JOptionPane.PLAIN_MESSAGE);
                result += 2;
                break;
        
            case 4:
                JOptionPane.showMessageDialog(null, 
                        "Ooh! This is great! I can have plenty of fun with this!" +
                        "\n\npoints: 4", title, JOptionPane.PLAIN_MESSAGE);
                result += 4;
                break;
        
            default:
                JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                break;
        }

        beat02 = "<html><h1 style='text-align:center;'>Chapter 2: Fido Eats...<h1>" +
                        "<p>Fido has worked up an appetite after the playing so much.</p>" +
                        "<p>Fido wonders what he should eat since his bowl is full of kibble.</p>" +
                        "<p>That's tasty and all... but there are other options.</p><br>" +
                        "<p>What's safe to eat?</p><br><br>" +
                        "<p>Please pick a number for you choice:</p><br>" +
                        "<p>1. Random house stuff</p>" +
                        "<p>2. Dog food</p>" +
                        "<p>3. Grapes on the floor</p>" +
                        "<p>4. Old, smelly leftovers somewhere in the house</p>";
        input = JOptionPane.showInputDialog(null, 
            beat02, 
            title, JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d+")){
            choice02 = Integer.parseInt(input);
        } else {
            JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        switch (choice02) {
            case 1:
                JOptionPane.showMessageDialog(null, 
                        "That taste always changes with whatever I get.\n" +
                        "Urgh...I don't know if that was a good idea.\n" +
                        "Oh well...I think...." +
                        "\n\npoints: 1", title, JOptionPane.PLAIN_MESSAGE);
                result += 1;
                break;
        
            case 2:
                JOptionPane.showMessageDialog(null, 
                        "It's the classic goto. Sometimes boring.\n" +
                        "I feel so much better when I eat this.\n" +
                        "I'm glad these hoomans take care of me!" +
                        "\n\npoints: 4", title, JOptionPane.PLAIN_MESSAGE);
                result += 4;
                break;
        
            case 3:
                JOptionPane.showMessageDialog(null, 
                        "Blegh!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
                        "I...don't...think...I'll survive...this again..." +
                        "\n\npoints: 0", title, JOptionPane.PLAIN_MESSAGE);
                result += 0;
                break;
                
        
            case 4:
                JOptionPane.showMessageDialog(null, 
                        "That was stinky, pleasant, and other things...\n" +
                        "Hmm...I think I might suffer later for this one..." +
                        "\n\npoints: 2", title, JOptionPane.PLAIN_MESSAGE);
                result += 2;
                break;
        
            default:
                JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                break;
        }

        beat03 = "<html><h1 style='text-align:center;'>Chapter 3: Fido Smells...<h1>" +
                        "<p>Lunch is always an experience for Fido. </p>" +
                        "<p>But the day isn't over, and Fido nose is itching.</p>" +
                        "<p>...it's curious. Fido hasn't sniffed the house much today.</p><br>" +
                        "<p>He's got some wiffs to sniff...what's safe to smell?</p><br><br>" +
                        "<p>Please pick a number for you choice:</p><br>" +
                        "<p>1. Something peculiar under the kitchen sink</p>" +
                        "<p>2. Some blankets near my bed</p>" +
                        "<p>3. The trashcan in the bathroom</p>" +
                        "<p>4. Some crumbs in the kitchen</p>";
        input = JOptionPane.showInputDialog(null, 
            beat03, 
            title, JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d+")){
            choice03 = Integer.parseInt(input);
        } else {
            JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        switch (choice03) {
            case 1:
                JOptionPane.showMessageDialog(null, 
                        "Hmm...this bottle is int...ahhh!!\n" +
                        "MY NOSE BURNS!!!\n" +
                        "Something sticky is on it...." +
                        "I may need to go to the vet now..." +
                        "\n\npoints: 1", title, JOptionPane.PLAIN_MESSAGE);
                result += 0;
                break;
        
            case 2:
                JOptionPane.showMessageDialog(null, 
                        "I know this smell!\n" +
                        "It's me!!! Hmmm....\n" +
                        "It's a little bit of my hooman too." +
                        "\n\npoints: 4", title, JOptionPane.PLAIN_MESSAGE);
                result += 4;
                break;
        
            case 3:
                JOptionPane.showMessageDialog(null, 
                        "I smell a lot of...pee???\n" + 
                        "We marking territory in here?\n" +
                        "OOh there's little things I can gobble in here too." +
                        "MUNCH!!!...." + 
                        "......." +
                        "..." +
                        "Uh oh....." +
                        "\n\npoints: 2", title, JOptionPane.PLAIN_MESSAGE);
                result += 2;
                break;
        
            case 4:
                JOptionPane.showMessageDialog(null, 
                        "Hmmm... what is this? Powder?\n" + 
                        "Baking Soda?\n" +
                        "Baking Powder?\n" +
                        "Cocaine?\n" +
                        "Chocolate Chip Cookes?\n" +
                        "Poison?\n" +
                        "Whatever it is...I licked it anyways..." +
                        "Hope they don't get mad." +
                        "\n\npoints: 3", title, JOptionPane.PLAIN_MESSAGE);
                result += 3;
                break;
        
            default:
                JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                break;
        }
        
        beat04 = "<html><h1 style='text-align:center;'>Chapter 4: Fido Plays Again...<h1>" +
                        "<p>This day has been eventful for Fido. </p>" +
                        "<p>But Fido still has a lot of energy left to burn.</p>" +
                        "<p>Around this time, he's itching for another play session.</p><br>" +
                        "<p>Depending on how earlier today went, yout gotta wonder...</p>" +
                        "<p>What is Fido gonna play with now?</p><br><br>" +
                        "<p>Please pick a number for you choice:</p><br>" +
                        "<p>1. A shoe</p>" +
                        "<p>2. Cooked chicken bone</p>" +
                        "<p>3. Raw, large beef bone</p>" +
                        "<p>4. Yak chews</p>";
        input = JOptionPane.showInputDialog(null, 
            beat04, 
            title, JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d+")){
            choice04 = Integer.parseInt(input);
        } else {
            JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        switch (choice04) {
            case 1:
                JOptionPane.showMessageDialog(null, 
                        "A classic...\n" +
                        "So tragic...\n" +
                        "To have it....\n" +
                        "With plastic...\n" +
                        "If I choke with it...\n" +
                        "Disastrous..." +
                        "\n\npoints: 1", title, JOptionPane.PLAIN_MESSAGE);
                result += 1;
                break;
        
            case 2:
                JOptionPane.showMessageDialog(null, 
                        "Well, it tastes good...\n" +
                        "Oh...something broke inside\n" +
                        "Ack! My throat!!!" +
                        "It hurts!!!!!" +
                        "I regret everything!!!" +
                        "HOSPITAL!!!!!!" +
                        "\n\npoints: 0", title, JOptionPane.PLAIN_MESSAGE);
                result += 0;
                break;
        
            case 3:
                JOptionPane.showMessageDialog(null, 
                        "This can do. Mmmh!!\n" + 
                        "Will I get sick since it's raw?\n" +
                        "Oh well. I like the taste." +
                        "\n\npoints: 2", title, JOptionPane.PLAIN_MESSAGE);
                result += 2;
                break;
        
            case 4:
                JOptionPane.showMessageDialog(null, 
                        "What is this?\n" + 
                        "The hoomans bought it.\n" +
                        "It's tasty.\n" +
                        "Meh. That's good enough for me.\n" +
                        "\n\npoints: 4", title, JOptionPane.PLAIN_MESSAGE);
                result += 4;
                break;
        
            default:
                JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                break;
        }

        beat05 = "<html><h1 style='text-align:center;'>Chapter 5: Fido Wants To Sleep...<h1>" +
                        "<p>After all that's happened during Fido's play, he's finally </p>" +
                        "<p>ready to rest.</p>" +
                        "<p>Where will he rest?</p><br><br>" +
                        "<p>Please pick a number for you choice:</p><br>" +
                        "<p>1. Outside on the concrete</p>" +
                        "<p>2. Dog bed</p>" +
                        "<p>3. The houses wooden floor</p>" +
                        "<p>4. The rug in the living room</p>";
        input = JOptionPane.showInputDialog(null, 
            beat05, 
            title, JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d+")){
            choice05 = Integer.parseInt(input);
        } else {
            JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        switch (choice05) {
            case 1:
                JOptionPane.showMessageDialog(null, 
                        "Brrr....it's cold!\n" +
                        "Ooof, my back!\n" +
                        "Maybe I should've picked a bed...zzzz...zzz" +
                        "\n\npoints: 0", 
                        title, JOptionPane.PLAIN_MESSAGE);
                result += 0;
                break;
        
            case 2:
                JOptionPane.showMessageDialog(null, 
                        "Ooooooohhhhh!!!......\n" +
                        "This is nice.....\n" +
                        "zzzzzzzzzzzzzzz\n" +
                        "zzzzzzzz\n" +
                        "zzzz" +
                        "\n\npoints: 4",
                        title, JOptionPane.PLAIN_MESSAGE);
                result += 4;
                break;
        
            case 3:
                JOptionPane.showMessageDialog(null, 
                        "This will do.\n" + 
                        "It's not the best.\n" +
                        "Better than outside, at least...zzzzz..." +
                        "\n\npoints: 1",
                        title, JOptionPane.PLAIN_MESSAGE);
                result += 1;
                break;
        
            case 4:
                JOptionPane.showMessageDialog(null, 
                        "Ahhhh.... This rug is nice\n" + 
                        "I think I'll have a good rest here.\n" +
                        "Maybe I should've picked my bed?\n" +
                        "This'll work for now....\n" +
                        "\n\npoints: 3", title, JOptionPane.PLAIN_MESSAGE);
                result += 3;
                break;
        
            default:
                JOptionPane.showMessageDialog(null, 
                        "Please choose an option by entering 1, 2, 3, or 4.\n" +
                        "I must now end the program. Please follow the rules next time.", 
                        title, JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                break;
        }

        
        resultMessage = "<html><h1 style='text-align:center'>The Results Are In</h1>" +
                        "<p>Total: " + result + "/20</p>" +
                        "</html>";

        if (result <= 5 && result >=0) {
            resultMessage += "Use chatGPT to get beginner lessons for dog care.\n" +
                             "Please don't let your pets suffer.\n" +
                             "Get some help and try this test again.\n";
        } else if (result > 5 && result <= 15) {
            resultMessage += "This gray area at least shows you got some knowledge.\n" +
                             "There's definitely room for improvement so build from\n" +
                             "here.\n\n" +
                             "Research and try this test again to see if you can get the\n" +
                             "perfect score!";
        } else if (result > 15 && result <=20) {
            resultMessage += "TOP SCORE!!!\n" +
                             "You are beyond the scope of this quiz. Congratulations!!!\n" +
                             "Know that your dog is safe in your care !😤!";
        } else {
            JOptionPane.showMessageDialog(null,
                             "Sorry that you made it all the way here to get an error.\n" +
                             "Tell Trevon Collins about it so he can figure out the issue.\n" +
                             "Bye! 👋",
                             title, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        JOptionPane.showMessageDialog(null, resultMessage, title, JOptionPane.INFORMATION_MESSAGE);
        

    }
}
