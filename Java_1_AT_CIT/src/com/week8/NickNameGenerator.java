package com.week8;

public class NickNameGenerator {

	public static String generatNickName(String fullName) {
		String nn1, nn2, nn3;
		if (fullName.length() < 4) {
			fullName += "XXXX";
		}
		String fullNameUC = fullName.toUpperCase();
		char char1 = fullNameUC.charAt(0);
		char char4 = fullNameUC.charAt(3);
		char chare = fullNameUC.charAt(fullNameUC.length() - 1);

		switch (char1) {
		case 'A':
			nn1 = "Slimmy";
			break;
		case 'B':
			nn1 = "Greasy";
			break;
		case 'C':
			nn1 = "Smelly";
			break;
		case 'D':
			nn1 = "Stinky";
			break;
		case 'E':
			nn1 = "Hairy";
			break;
		case 'F':
			nn1 = "Groovy";
			break;
		case 'G':
			nn1 = "Wily";
			break;
		case 'H':
			nn1 = "Decaying";
			break;
		case 'I':
			nn1 = "Flaming";
			break;
		case 'J':
			nn1 = "Pale";
			break;
		case 'K':
			nn1 = "Skinny";
			break;
		case 'L':
			nn1 = "Whingy";
			break;
		case 'M':
			nn1 = "Whiny";
			break;
		case 'N':
			nn1 = "Graceful";
			break;
		case 'O':
			nn1 = "Aging";
			break;
		case 'P':
			nn1 = "Smiley";
			break;
		case 'Q':
			nn1 = "Foxy";
			break;
		case 'R':
			nn1 = "Hungry";
			break;
		case 'S':
			nn1 = "Lazy";
			break;
		case 'T':
			nn1 = "Stylish";
			break;
		case 'U':
			nn1 = "Silent";
			break;
		case 'V':
			nn1 = "Rowdy";
			break;
		case 'W':
			nn1 = "Raging";
			break;
		case 'X':
			nn1 = "Oversized";
			break;
		case 'Y':
			nn1 = "Scary";
			break;
		case 'Z':
			nn1 = "Slimmy";
			break;

		default:
			nn1 = "Daring";
		}
		switch (char4) {
		case 'A':
			nn2 = "Foot";
			break;
		case 'B':
			nn2 = "Toe";
			break;
		case 'C':
			nn2 = "Boot";
			break;
		case 'D':
			nn2 = "Butt";
			break;
		case 'E':
			nn2 = "Earwax";
			break;
		case 'F':
			nn2 = "Armpit";
			break;
		case 'G':
			nn2 = "Nosehair";
			break;
		case 'H':
			nn2 = "Wig";
			break;
		case 'I':
			nn2 = "False teeth";
			break;
		case 'J':
			nn2 = "Blood";
			break;
		case 'K':
			nn2 = "Snot";
			break;
		case 'L':
			nn2 = "Nappy";
			break;
		case 'M':
			nn2 = "Hair";
			break;
		case 'N':
			nn2 = "Pig";
			break;
		case 'O':
			nn2 = "Donkey";
			break;
		case 'P':
			nn2 = "Mud";
			break;
		case 'Q':
			nn2 = "Whisker";
			break;
		case 'R':
			nn2 = "Eyebrow";
			break;
		case 'S':
			nn2 = "Tyre";
			break;
		case 'T':
			nn2 = "Spit";
			break;
		case 'U':
			nn2 = "Toad";
			break;
		case 'V':
			nn2 = "Wart";
			break;
		case 'W':
			nn2 = "Paint";
			break;
		case 'X':
			nn2 = "Beard";
			break;
		case 'Y':
			nn2 = "Moustache";
			break;

		default:
			nn2 = "Dirt";
		}

		switch (chare) {
		case 'A':
			nn3 = "Sipper";
			break;
		case 'B':
			nn3 = "Slurper";
			break;
		case 'C':
			nn3 = "Tickler";
			break;
		case 'D':
			nn3 = "Snorter";
			break;
		case 'E':
			nn3 = "Scratcher";
			break;
		case 'F':
			nn3 = "Puller";
			break;
		case 'G':
			nn3 = "Slapper";
			break;
		case 'H':
			nn3 = "Kicker";
			break;
		case 'I':
			nn3 = "Nibbler";
			break;
		case 'J':
			nn3 = "Gargler";
			break;
		case 'K':
			nn3 = "Chucker";
			break;
		case 'L':
			nn3 = "Tosser";
			break;
		case 'M':
			nn3 = "Washer";
			break;
		case 'N':
			nn3 = "Cleaner";
			break;
		case 'O':
			nn3 = "Gouger";
			break;
		case 'P':
			nn3 = "Waxer";
			break;
		case 'Q':
			nn3 = "Stealer";
			break;
		case 'R':
			nn3 = "Painter";
			break;
		case 'S':
			nn3 = "Peeler";
			break;
		case 'T':
			nn3 = "Grower";
			break;
		case 'U':
			nn3 = "Groveller";
			break;
		case 'V':
			nn3 = "Hugger";
			break;
		case 'W':
			nn3 = "Twirler";
			break;
		case 'X':
			nn3 = "Grabber";
			break;
		case 'Y':
			nn3 = "Wobbler";
			break;

		default:
			nn3 = "Eater";
		}
		return nn1 + " " + nn2 + " " + nn3;

	}

}
