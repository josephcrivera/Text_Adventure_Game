/**
 * Class Game - the main class of the text adventure.
 *
 * Author:  Joseph Rivera
 * Version: 3.0
 * Date:    Feb 8 2023
 * 
 */import java.util.*;class Game {    private Parser parser=new Parser();    private Room currentRoom;    private Inventory myInventory=new Inventory();    private Room courtyard1,courtyard2,courtyard3,courtyard4,courtyard5,courtyard6,courtyard7,courtyard8,courtyard9,courtyard10,courtyard11,courtyard12,courtyard13,courtyard14,courtyard15,courtyard16,courtyard17,courtyard18,courtyard19,courtyard20,courtyard21,courtyard22;    final private String DEAD="***************YOU HAVE DIED***************";
		public int stage = 0;            public Game()     {        createRooms();    }    private void createRooms()    {      courtyard1 = new Room("*CASTLE LOBBY*\nYou are in a grandiose room. The polished marble floors lead into imposing stone walls. There is a large lockedGate north of you.");
			courtyard2 = new Room("*EAST CORRIDOR*\nSunlight filters through the large stained glass windows. You can see an odd statue in the room to your east...");
			courtyard3 = new Room("*END OF EAST CORRIDOR*\nThere is a stone turtle statue in the middle of the room. It has a shiny sword sticking out its shell.");
			courtyard4 = new Room("*STORAGE ROOM*\nThere are loads of chests with metal locks on them. Pressed up against the far wall of the room, there is a chest without a lock... .");
			courtyard5 = new Room("*LIBRARY*\nThe large shelves and smell tell you that this used to be a library. Yet it is abandoned, and most of the books are no longer there. On a pedastal in the middle of the room there is an open book.");
			courtyard6 = new Room("*WEST CORRIDOR*\nThe room is impossibly dark, with the only light coming from the next room over");
			courtyard7 = new Room("*BRAZIER ROOM*\nThere are four torches that illuminate the room. The blueTorch and the silverTorch are on the left side of the room. The yellowTorch and the greenTorch are on the right side of the room. In the center of them, is an empty brazier.");
			courtyard8 = new Room("*SECRET ROOM*\nThere is a marble pedastal in the middle of the room. On it, lies a glowing orb.");
			courtyard9 = new Room("*SOUTH CORRIDOR*\nThere is a locked door to the south. Above the keyhole, there is an engraving of a star...");
			courtyard10 = new Room("*DINING ROOM*\nThis appears to be a dining room. Or at least, it used to be a dining room as the table has been flipped over and food is strewn across the floor. A snake-like creature jumps out and starts running toward you! (It is directly in front of the south exit) ");
			courtyard11 = new Room("*BRIDGE*\nYou enter the room and immediately notice that there is a huge pit where the floor should be. However, there is a wooden bridge leading to the other side of the room. There is a sign above the bridge that says 'Hoc est captionem'. (Your latin is a bit rusty though...)");
			courtyard12 = new Room("*KITCHEN*\nLarge furnaces line the walls, accompanied by a myriad of pots on the shelves. You can hear a clanking noise from your west");
			courtyard13 = new Room("*STORAGE ROOM*\nThe room is filled with large gears that creak and clank as they turn.");
			courtyard14 = new Room("*TRIAL ENTRANCE*\nThere is a large obsidian door to your east. It has an engraving on the wall next to it.");
			courtyard15 = new Room("*TRIAL 1*\nYou enter the room and see large pipes lining the walls. Suudenly, on the ceiling, one of the pipes bursts and begins to spew water. The burstPipe is quickly filling up the room.");
			courtyard16 = new Room("*TRIAL 2*\nThe cobblestone walls are lined with moss and vines. In the center of the room stands a turret. It is ready to fire.");
			courtyard17 = new Room("*TRIAL 3*\nThe room is humid and it smells of hot garbage. In the center of the room sits a giant ogre. Upon you entrance, it turns and looks at you.");
			courtyard18 = new Room("*TRIAL 4*\nAlong the walls, ornate swords are on display. On one of the hooks is a gleaming gold ring.");
			courtyard19 = new Room("*DUNGEON ENTRANCE*\nTo your south, you see a massive steelDoor. It is the size of the walls, with ornate designs on it. It exudes a menancing aura, hinting that something sinister lurks behind it. To the right of the door, there is a message on the wall. To the left of the door, there is a handIndentation");
			courtyard20 = new Room("*DUNGEON*\nDespite the torches that line the room, it is intimidatingly dark. At the center of the room lies the sleeping knightOfDrogo.");
			courtyard21 = new Room("*PORTAL ROOM*\nA swirling portal opens on the left wall. It begins pulling the bricks out of the walls, destroying the room. You need to get out of there. But, in the next room you can see a largeGem");
			courtyard22 = new Room("*SPIKE ROOM*\nA humongous gem is levitating in the middle of the room. Around it are chests overflowing with gold coins, and trinkets. Its almost too good to be true.");



			// N, E, S, W
			courtyard1.setExits(null, courtyard2, courtyard9, courtyard6);
			courtyard2.setExits(null,courtyard3,null,courtyard1);
			courtyard3.setExits(null,null,courtyard4,courtyard2);
			courtyard4.setExits(courtyard3,courtyard5,null,null);
			courtyard5.setExits(null,null,null,courtyard4);
			courtyard6.setExits(null,courtyard1,null,courtyard7);
			courtyard7.setExits(null,courtyard6,null,null);
			courtyard8.setExits(null,null,courtyard7,null);
			courtyard9.setExits(courtyard1,null,null,null);
			courtyard10.setExits(courtyard9,null,null,courtyard11);
			courtyard11.setExits(null,courtyard10,null,null);
			courtyard12.setExits(courtyard10,null,courtyard14,courtyard13);
			courtyard13.setExits(null,courtyard12,null,null);
			courtyard14.setExits(courtyard12,courtyard15,null,null);
			courtyard15.setExits(null,null,null,courtyard14);
			courtyard16.setExits(courtyard15,null,null,null);
			courtyard17.setExits(courtyard16,null,null,null);
			courtyard18.setExits(null,courtyard17,null,null);
			courtyard19.setExits(null,courtyard18,null,null);
			courtyard20.setExits(courtyard19,null,null,null);
			courtyard21.setExits(courtyard22,null,courtyard1,null);
			courtyard22.setExits(null,null,courtyard21,null);

			//doors
			courtyard1.addItem(new Item("bigGate", "environment", "A bigGate made of cruel black steel that extends from the floor to the ceiling. It is firmly locked."));
			courtyard9.addItem(new Item("lockedDoor", "environment", "A plain wooden lockedDoor. It has a star engraved on it."));
			courtyard19.addItem(new Item("steelDoor","environment","A beautifully crafted steelDoor. It is locked. Above the doorknobs, there are 4 symbols for the trial charms."));
			courtyard21.addItem(new Item("portal","environment","A rift in the space-time continium. On the other side you can see your home... "));

			//chests
			courtyard4.addItem(new Item("chest","environment","A simple wooden chest. Theres a starKey inside of it."));

			//puzzle items
			courtyard3.addItem(new Item("turtleStatue","environment","*RIDDLE*\nI'm tall when I'm young, and I'm short when I'm old. What am I?"));

			courtyard7.addItem(new Item("blueTorch","pickup","A torch with a blue flame. On the handle, the word 'Ouranos' is engraved."));
			courtyard7.addItem(new Item("yellowTorch","pickup","A torch with a yellow flame. On the handle, the word 'Helios' is engraved. "));
			courtyard7.addItem(new Item("greenTorch","pickup","A torch with a green flame. On the handle, 'Gaea' is engraved."));
			courtyard7.addItem(new Item("silverTorch","pickup","A torch with a silver flame. On the handle, the word 'Selene' is engraved"));
			courtyard7.addItem(new Item("brazier","environment","A giant metal brazier. It is unlit, but in the center it has some firewood. There is a scroll attached to its side that reads 'Only the ruler of the twilight can ignite this fire'"));
			courtyard11.addItem(new Item("bridge","environment","A rickety bridge"));

			courtyard15.addItem(new Item("burstPipe", "environment", "A metal pipe spewing water. It may be possible to fix the hole..."));

			courtyard16.addItem(new Item("turret","environment","A threatening turret filled with sharp arrows. It is pointed directly in your direction."));
			
			courtyard18.addItem(new Item("ring","environment","*RIDDLE*\nThirty white horses on a red hill,\nFirst they champ,\nThen they stamp,\nThen they stand still."));
			

			//other items
			courtyard22.addItem(new Item("largeGem","pickup","A gem the size of your head. Perhaps this is the one that the fables spoke of..."));
			courtyard5.addItem(new Item("book","environment","There is a single sentence written in the book. It reads:\nWe bleed \nbecause we need \nto feed our greed"));
			courtyard8.addItem(new Item("pedastal","environment","On the pedastal, rests a glowing orb. A scroll next to it reads:\nA gift from my brother Helios"));
			courtyard8.addItem(new Item("orb","pickup","It is the size of your palm but you can feel an immense heat within it. Looking closely, it looks as though it is a ball of pure flames."));
			courtyard14.addItem(new Item("engraving","environment","Once you pass this threshold, you cannot go back. Make sure you are ready"));
			courtyard19.addItem(new Item("message","environment","*WARNING*\nThis is where the Colossus Knight of Drogo resides. He will be your final trial. Make sure your equipment is sufficient to survive."));
			courtyard19.addItem(new Item("handIndentation","environment","An indenation in the shape of a hand."));

			//characters
			courtyard10.addItem(new Item("creature","environment","Its skin is made of durable scales that seem to be emittng heat. Its getting closer!"));
			courtyard17.addItem(new Item("ogre","environment","The lumbering ogre roars at you. It picks up its giant club."));
			courtyard20.addItem(new Item("knightOfDrogo","environment","A knight in pitch black armor with a blindingly bright silver sword. He is asleep.\n(HINT: It's a multi-stage fight)"));
			currentRoom = courtyard1;
			    }    public void play()     {                    printWelcome();        boolean finished = false;        while (! finished)        {            Command command = parser.getCommand();            finished = processCommand(command);        }        System.out.println("Thank you for playing.  Good bye.");    }    private void printWelcome()    {   
			  System.out.println();        System.out.println(" ------------------");        System.out.println("|Twilight's Warrior| - written by Joseph Rivera");        System.out.println(" ------------------");        System.out.println("You wake up in a large castle. You were searching for the fabled Knight of Drogo so that you could subdue him and get revenge for your village. Yet, you can't remember exactly how you got into this castle. \nNo matter, it is time to explore.");
				System.out.println("\nType 'help' if you need help with commands and getting around.");        System.out.println();        System.out.println(currentRoom.longDescription());    }    private boolean processCommand(Command command)     {        if(command.isUnknown())        {            System.out.println("I don't know what you mean...");            return false;        }        String commandWord = command.getCommandWord();        if (commandWord.equals("help"))            printHelp();        else if (commandWord.equals("inventory"))  			myInventory.listItems();  		else if (commandWord.equals("examine"))  			examineItem(command);  		else if (commandWord.equals("answer"))  			answerRiddle(command);  		else if (commandWord.equals("use"))  			useItem(command);        else if (commandWord.equals("go"))            goRoom(command);        else if (commandWord.equals("get"))            getItem(command);        else if (commandWord.equals("quit"))        {            if(command.hasSecondWord())                System.out.println("Quit what?");            else                return true;        }        return false;    }    private void printHelp()     {        System.out.println("You are in a dangerous castle");        System.out.println("To get out you need to use special command words.  Examples: 'go north', 'examine book', 'use knife'");        System.out.println("Your command words are:");        parser.showCommands();    }	          private void examineItem(Command command)    {
			Scanner input = new Scanner(System.in);    	        if(!command.hasSecondWord())        {					System.out.println("Examine what?");					return;        }        String item = command.getSecondWord();        if (item.equals("room"))        {        	System.out.println(currentRoom.longDescription());        }
				else if (item.equals("chest"))
				{
					Item roomItem=currentRoom.checkItemInRoom(item);
					System.out.println(roomItem.getDescription()); 
					currentRoom.addItem(new Item("starKey","pickup","A small metal key with a star engraved on the handle"));
				}
				else if(item.equals("bridge"))
				{
					System.out.println("You begin to walk across the bridge. Halfway across the bridge, you hear a large snap. One of the cables split and the bridge falls...\n"+DEAD);
				}
				else if(item.equals("portal"))
				{
					Item roomItem=currentRoom.checkItemInRoom(item);
					System.out.println(roomItem.getDescription());
					System.out.println("Are you ready to go home? (y/n)");
					String ans = input.nextLine();
					if(!ans.equals("y"))
					{
						System.out.println("Hurry, the portal will not stay open for too long. Grab what you need and go!");
					}
					else if(ans.equals("y"))
					{
						System.out.println("***GAME COMPLETE***\n\nYou enter the portal, and are immediately transported back to your camp. Unfortunately, the portal was not careful, because you ended up on the top of your house. Well, at least your safe.");
						System.out.println("In your head, you hear an angleic voice begin to speak:\n'Thank you warrior for completing my trials and slaying the knight. As a reward, you have my blessing'");
						System.out.println("*You live out the rest of your days in peace and prosperity, enjoying life to the fullest*");
						endGame();
					}
					//stopped here
				}
				else if(item.equals("handIndentation"))
				{
					if(myInventory.checkInventory("fireCharm")!=null && myInventory.checkInventory("swordCharm")!=null && myInventory.checkInventory("shieldCharm")!=null && myInventory.checkInventory("bookCharm")!=null)
					{
						System.out.println("You place your hand in the slot and the charms in your pocket begin to glow in unison, before going dark. The door to your south creaks open");
						currentRoom.setExits(null,courtyard18,courtyard20,null);
					}
					else
					{
						System.out.println("You place your hand in the slot but nothing happens. (You do not hold all of the charms needed to unlock this door. Go collect them from the previous rooms)");
					}
				}        else        {	        Item roomItem=currentRoom.checkItemInRoom(item);	        Item inventoryItem=myInventory.checkInventory(item);	        if (roomItem!=null)	        {	        	System.out.println(roomItem.getDescription()); 		        }	        else if (inventoryItem!=null)	        {	        	System.out.println(inventoryItem.getDescription());	        }	        else	        {	        	System.out.println("I can't examine that.");	        }        }    }        private void answerRiddle(Command command)    {    	if(!command.hasSecondWord())      {				System.out.println("Type 'answer' followed by your answer.");				return;			}			String item = command.getSecondWord();
			if(currentRoom.checkItemInRoom("turtleStatue")!=null){
				if(item.equals("candle")){
					System.out.println("The statue's eyes glow a bright white before going dark. The shell loosens up to allow easier access to the sword.");
					currentRoom.removeItem("tutrleStatue");
					currentRoom.setDescription("*END OF EAST CORRIDOR*\nIn the middle of the room lies the turtleStatue where you got the sword from.");
					currentRoom.addItem(new Item("sword","pickup","A shiny steel sword. This is great for slaying foes."));
					currentRoom.checkItemInRoom("turtleStatue").setDescription("A stone turtleStatue that lacks the sword it once held.");
				}
				else{
					System.out.println("The statue's eyes glow a dark red as the sword from its back levitates into the air. Its pointed straight at you...\n"+DEAD); 
				}
			}
			else if(currentRoom.checkItemInRoom("ring")!=null){
				if(item.equals("teeth")){
					System.out.println("A small bookCharm appears out of the air.");
					currentRoom.addItem(new Item("bookCharm","pickup","A shiny charm in the shape of a book."));
					currentRoom.setExits(null,courtyard17,null,courtyard19);
					currentRoom.removeItem("ring");
					currentRoom.setDescription("*TRIAL 4*\nAlong the walls, ornate swords are on display. The gleaming gold ring is gone.");
					System.out.println("The swords levitate off of the wall and aim themselves at the west wall. They fly at it, carving out a hole for you pass through.");
				}
			}			else			{				System.out.println("There's nothing to answer here.");			}    }            private void useItem(Command command)    {    	if(!command.hasSecondWord())        {            System.out.println("Use what?");            return;        }			String item = command.getSecondWord();					Item roomItem=currentRoom.checkItemInRoom(item);			Item inventoryItem=myInventory.checkInventory(item);
			if(inventoryItem!=null)
			{
				if(item.equals("silverTorch") && currentRoom.checkItemInRoom("brazier")!=null)
				{
					System.out.println("North of you, the wall begins to shake before displaying a secret doorway.");
					currentRoom.setExits(courtyard8,courtyard6,null,null);
				}
				else if(item.equals("blueTorch") && currentRoom.checkItemInRoom("brazier")!=null)
				{
					System.out.println("A giant blue hand appears out of the air and crushes you\n"+DEAD);
				}
				else if(item.equals("yellowTorch") && currentRoom.checkItemInRoom("brazier")!=null)
				{
					System.out.println("The room starts getting very hot and then you burst into flames\n"+DEAD);
				}
				else if(item.equals("greenTorch") && currentRoom.checkItemInRoom("brazier")!=null)
				{
					System.out.println("Vines erupt out of the ground and wrap you in a tight bind. They keep squeezing...\n"+DEAD);
				}
				else if(item.equals("starKey") && currentRoom.checkItemInRoom("lockedDoor")!= null)
				{
					System.out.println("The door swings open. You can now go south");
					currentRoom.setExits(courtyard1,null,courtyard10,null);
					currentRoom.setDescription("There is an open door to your south");
					currentRoom.removeItem("lockedDoor");
				}
				else if(item.equals("sword") && currentRoom.checkItemInRoom("creature")!=null)
				{
					System.out.println("You swing your sword and it cleaves right through the creature. The creature is slain");
					currentRoom.removeItem("creature");
					courtyard10.setExits(courtyard9,null,courtyard12,courtyard11);
					currentRoom.setDescription("You are in a dining room. Or at least, it used to be a dining room as the table has been flipped over and food is strewn across the floor. The creature is no more");
				}

				else if(item.equals("orb") && currentRoom.checkItemInRoom("creature")!=null)
				{
					System.out.println("You nervously hold the orb up as the creature approaches. A large column of flame erupts out and burns the creature to a crisp.");
					currentRoom.removeItem("creature");
					courtyard10.setExits(courtyard9,null,courtyard12,courtyard11);
					currentRoom.setDescription("You are in a dining room. Or at least, it used to be a dining room as the table has been flipped over and food is strewn across the floor. The creature is no more");
				}
				else if(item.equals("starKey") && currentRoom.checkItemInRoom("creature")!=null)
				{
					System.out.println("You chuck the key at the creature, and it harmlessly bounces off its head. Uh oh...\n"+DEAD);
				}
				
				else if(item.equals("orb") && currentRoom.checkItemInRoom("burstPipe")!=null)
				{
					System.out.println("As the room fills up, you struggle to keep you head above the water. When you finally get close to the burstPipe, you pull out the orb and point it at the rupture.");
					System.out.println("Flames erupt from the orb, mending the hole and stopping the influx of water. The room then drains out, revealing an exit to the south");
					currentRoom.removeItem("burstPipe");
					currentRoom.setExits(null,null,courtyard16,courtyard14);
					System.out.println("A fireCharm appears out of the sky");
					currentRoom.addItem(new Item("fireCharm", "pickup", "A shiny charm in the shape of a fire"));
					currentRoom.setDescription("You enter the room and see large pipes lining the walls. You can see the crude welding job that you did on the one on the ceiling. The floor is still wet...");
				}
				else if(item.equals("sword") && currentRoom.checkItemInRoom("burstPipe")!=null)
				{
					System.out.println("You begin swingin' your sword around wildly. You ended up slashing through more pipes and casuing the room to fill up even faster. After the water level passes your head, you realize maybe violence isn't alwasy the option.\n"+DEAD);
				}
				else if(item.equals("shield") && currentRoom.checkItemInRoom("burstPipe")!=null)
				{
					 System.out.println("You vigourously throw your shield at the rupture. It bounces off the pipe and hits you directly in the head. You get knocked out, and the room continues to fill up. Have a nice nap!\n"+DEAD);
				}

				else if(item.equals("shield") && currentRoom.checkItemInRoom("turret")!=null)
				{
					System.out.println("You pull out your shield and hunker down behind it. The turret begins to fire, but the shield protects you. Eventuallly, it runs out of ammo.");
					System.out.println("You throw your shield at the turret, and it flies through the air, hitting the turret and lodging itself in the wall. The wall crumbles revealing a new room to your south");
					currentRoom.removeItem("turret");
					currentRoom.setExits(courtyard15,null,courtyard17,null);
					System.out.println("A shieldCharm appears out of the air.");
					currentRoom.addItem(new Item("shieldCharm", "pickup", "A shiny charm in the shape of a shield"));
					currentRoom.setDescription("The cobblestone walls are lined with moss and vines. In the center of the room lies a scorch mark where the turret used to be.");
				}
				else if(item.equals("sword") && currentRoom.checkItemInRoom("turret")!=null)
				{
					System.out.println("Brandishing your sword, you attempt to chgarge the turret. Obviously, this does not go well and the turret fires directly into your chest.\n"+DEAD);
				}
				else if(item.equals("orb") && currentRoom.checkItemInRoom("turret")!=null)
				{
					System.out.println("Your extend the orb and a column of fire erupst out of it. A good idea, except for the fact that the turret is immune to magic. And it begins to humm dangerously...\n"+DEAD);
				}

				else if(item.equals("starKey") && currentRoom.checkItemInRoom("ogre")!=null)
				{
					System.out.println("You are out of ideas and decide to throw the key at the ogre. Luckily, you have great timing and it goes in its mouth as it is roaring. The ogre begins to choke before exploding into a fine gold dust.");
					currentRoom.removeItem("ogre");
					System.out.println("A swordCharm appears out of the air.");
					currentRoom.addItem(new Item("swordCharm", "pickup", "A shiny charm in the shape of a sword"));
					currentRoom.setDescription("*TRIAL 3*\nThe room is humid and it smells of hot garbage. The ogre is no more");
					System.out.println("You can see that the ogre's explosion blew a hole in the west wall. You can see another room that way.");
					currentRoom.setExits(courtyard16,null,null,courtyard18);
				}
				else if(item.equals("orb") && currentRoom.checkItemInRoom("ogre")!=null)
				{
					System.out.println("You point the orb at the orge and a column of fire erupts from it. Unfortunately, the flames pass hamrlessly across its skin. It menancingly raises its club above its head...\n"+DEAD);
				}
				else if(item.equals("sword") && currentRoom.checkItemInRoom("ogre")!=null)
				{
					System.out.println("You swing you sword at the ogre's midsection but the blade simply bounces off. The ogre picks you up and opens it mouth. Uh oh..\n"+DEAD);
				}
				else if(item.equals("shield") && currentRoom.checkItemInRoom("ogre")!=null)
				{
					System.out.println("You hunker behind your shield. This does nothing to deter the ogre as it swings its club at you full force. You crash hard into the wall and your vision goes dark\n"+DEAD);
				}

				else if(item.equals("sword") && currentRoom.checkItemInRoom("knightOfDrogo")!=null && stage == 0)//correct path 1 start
				{
					System.out.println("You swing your sword toward his exposed nape. Suddenly, he wakes up and grabs your sword before it can touch him. Staring into your eyes as he does it, he snaps the sword in half. Throwing you back, he unsheaths his sword.");
					myInventory.removeItem("sword");
					stage++;
				}
				else if(item.equals("orb") && currentRoom.checkItemInRoom("knightOfDrogo")!=null && stage == 1)//incorrect path 1 mid
				{
					System.out.println("You pull out your orb to blast him, but he has already begun his attack. And it is headed directly for your chest...\n"+DEAD);
				}
				else if(item.equals("shield") && currentRoom.checkItemInRoom("knightOfDrogo")!=null && stage == 1)//correct path 1 mid
				{
					System.out.println("Quickly, you raise your shield in front of you. It was just in time, as his sword clangs heavily against it, tossing you into the wall. The shield gets knocked out of your hands.");
					System.out.println("He rushes over to you and raises his sword over his head.");
					myInventory.removeItem("shield");
					stage++;
				}
				else if(item.equals("orb") && currentRoom.checkItemInRoom("knightOfDrogo")!=null && stage == 2)//correct path 1 end
				{
					System.out.println("You point the orb at the knight and his eyes widen in fear. But before he can retreat fully, a powerful stream of fire comes out of the orb.");
					System.out.println("It hits him directly in the face, and he cries out in pain. He drops to the floor, trying to put the flames out. It works, but he passes out.");
					System.out.println("On his hip, you can see a diamondKey.");
					currentRoom.removeItem("knight");
					currentRoom.addItem(new Item("diamondKey","pickup","A shimmering diamond key. This looks extremely important."));
					currentRoom.setDescription("*DUNGEON*\nDespite the torches that line the room, it is intimidatingly dark. The knight is still passed out on the floor.");
					stage = 10;
				}

				else if(item.equals("orb") && currentRoom.checkItemInRoom("knightOfDrogo")!=null && stage == 0)//correct path 2 start
				{
					System.out.println("You point the orb at the sleeping knight and it unleashes a tidal wave of fire onto him. After the flames pass, you see that he is alive, but his injuries have him staggered.");
					stage+=3;
				}
				else if(item.equals("sword") && currentRoom.checkItemInRoom("knightOfDrogo")!=null && stage == 3)//correct path 2a end
				{
					System.out.println("You begin to run around the knight, goading him into an attack. As he swings at you and misses his blade gets lodged in the ground.");
					System.out.println("You take the opportunity and with a jump attack, land a fatal blow on the Colossus Knight. Once his body falls, you can see a diamondKey on his hip");
					currentRoom.removeItem("knight");
					currentRoom.addItem(new Item("diamondKey","pickup","A shimmering diamond key. This looks extremely important."));
					currentRoom.setDescription("*DUNGEON*\nDespite the torches that line the room, it is intimidatingly dark. The knight's body lay motionless on the floor.");
					stage = 10;
				}
				else if(item.equals("shield") && currentRoom.checkItemInRoom("knightOfDrogo")!=null && stage == 3)//correct path 2b end
				{
					System.out.println("You run inside the staggered knight's guard, and hit him directly in the face with your shield. He immediately crumples to the ground due to the power of your blow.");
					System.out.println("On his unconscious body falls, you can see a diamondKey on his hip");
					currentRoom.removeItem("knight");
					currentRoom.addItem(new Item("diamondKey","pickup","A shimmering diamond key. This looks extremely important."));
					currentRoom.setDescription("*DUNGEON*\nDespite the torches that line the room, it is intimidatingly dark. The knight is still passed out on the floor.");
					stage = 10;
				}
				else if(item.equals("orb") && currentRoom.checkItemInRoom("knightOfDrogo")!=null && stage == 3)//correct path 2c end
				{
					System.out.println("You run inside the staggered knight's guard, and blast him directly in the face with the orb. He cries out before crumpling to the ground.");
					System.out.println("Once his corpse  falls, you can see a diamondKey on his hip");
					currentRoom.removeItem("knight");
					currentRoom.addItem(new Item("diamondKey","pickup","A shimmering diamond key. This looks extremely important."));
					currentRoom.setDescription("*DUNGEON*\nDespite the torches that line the room, it is intimidatingly dark. The knight's body lay motionless on the floor.");
					stage = 10;
				}

				else if(item.equals("shield") && currentRoom.checkItemInRoom("knightOfDrogo")!=null && stage == 0)//incorrect path 1 start
				{
					System.out.println("You chuck your shield at his head, but it bounces off harmlessly off his helmet. The knight is now awake and he unsheathes his shield.");
					System.out.println("With no defence available, you hold out your sword in front of you. The knight's first strike breaks your blade in two and you close your eyes as he lanches his second...\n"+DEAD);
				}
				
				
				
				else if(item.equals("diamondKey") && currentRoom.checkItemInRoom("bigGate")!=null)
				{
					System.out.println("You stick the key into the keyhole and it turns. But as the gates begin to open, the key dissolves in your hand");
					System.out.println("The gate swings open, and you can now go north. You can see a strange gleaming light in the next room...");
					myInventory.removeItem("diamondKey");
					currentRoom.setExits(courtyard21,courtyard2,courtyard9,courtyard6);
				}
				else
				{
					System.out.println("You can't use that here");
				}
			}
			else if(roomItem!=null)
			{
				System.out.println("You can't use that");
			}
			else
			{
				System.out.println("You have nothing to use");
			}
			    }
    private void goRoom(Command command)     {        if(!command.hasSecondWord())        {            System.out.println("Go where?");            return;        }        String direction = command.getSecondWord();        Room nextRoom = currentRoom.nextRoom(direction);
				if(nextRoom == null)
				{
					System.out.println("There is no door!");
				}
				else         {            currentRoom = nextRoom;            System.out.println(currentRoom.longDescription());        }    }        private void getItem(Command command)    {    	if(!command.hasSecondWord())        {            System.out.println("Get what?");            return;        }        String item = command.getSecondWord(); 		Item currentItem=currentRoom.checkItemInRoom(item);        if (currentItem==null )        {        	System.out.println("I don't see that here.");        }        else if (currentItem.getType()!="pickup")        {        	System.out.println("You can't pick that up.");        }               else if (currentItem!=null)        {        	myInventory.addItem(currentItem);        	currentRoom.removeItem(currentItem.getName());        	System.out.println("You picked up the " + item);
					if(currentItem.getName().equals("starKey"))
					{
						currentRoom.setDescription("*STORAGE ROOM*\nThere are loads of chests with metal locks on them. This is where you got the starKey");
						currentRoom.checkItemInRoom("chest").setDescription("An simple wooden chest. It is empty");
					}
					else if(currentItem.getName().equals("orb"))
					{
						System.out.println("The power of the sun.. in the palm of your hand");
					}
					else if (currentItem.getName().equals("largeGem"))
					{
						System.out.println("The building begins to violently shake. A booming voice cries out:\n'What did I tell you?!\nDid you not read the book?!\nI explictly said to NOT be greedy!!\nGodbye then...'");
						System.out.println("You look up and you see the ceiling begin to crack. Then with a large boom, it falls.\n"+DEAD);
					}
        }    }    private void endGame()    {    	System.exit(0);    }}