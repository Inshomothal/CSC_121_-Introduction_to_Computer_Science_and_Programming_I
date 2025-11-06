Project 03 by Trevon Collins

What Is The Goal?
    This program simulates the card game "Black Jack", also known as "21" and "Black Jack 21". Your goal is to get a higher score than the dealer without busting by going over 21.

How To Use the Code
    When you run the program, it will give you three options for how to play.
        1. Hit
        2. Stand
        3. Choose for me
    
    When you hit, the program will add the next card in the deck to your hand and reevaluate your score to see if you are still under 21. If you go over 21, you lose; same for the dealer. If you ever choose not to draw anymore cards, you can "Stand" to give the turn to the dealer. Once the dealer stands, the winner is the highest score among you. If either of you reach 21, you automatically win. If either of you go beyond 21, you lose.

    This code is limited to a player and an AI at this moment. If we're given a 2nd chance, I can expand it to have the option for more players.

    The third option will allow the AI to choose whether you should hit based on the current "Basic Strategy" table that was created by the BlackJackApprenticeship.com. Give a try when you're unsure if you should hit or stand. PLEASE DON'T EXPECT it to always win the game for you.

Technical Info
    The program runs on String parsing. We heavily utilize String functionality to shuffle the deck and get the first card for the deck. The crucial part of this system is the code that makes and shuffles the deck. Afterwards, the other functions are all about taking in Strings and returning values from that.