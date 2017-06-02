package gui.kbc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class backendclass
{
static    questionsgui beg = new questionsgui();

     static Scanner input = new Scanner( System.in );
	static int money=0, i ;
	static int fifty=1, audiencepole=1, skipquestion=1, redeem=1;
	static String username;
	static char charchoice;
	static questionclass questionobj = new questionclass();
	
	public static void main( String ar[] )
	{
	    menu();
	}
	
static void menu()
{
	Scanner input = new Scanner( System.in );
	
    char charchoice=' ' ;
	
	while( charchoice != 'e' )
	{
		 charchoice = maindisplay();
		 
		 switch (charchoice)
		 {
		       case 'p' : play();
		                  break;
		       case 'v' : viewhighscores();
		                  break;   
		       case 'e' : break;       
		       default  : System.out.println( "wrong option !!!" );
		                  break;
		 }
	}
}
static char maindisplay()
{
	Scanner input = new Scanner( System.in );
	char charchoice;
	System.out.println( "***** KAUN BANEGA CROREPATI *****" );
	System.out.print( "\n" );
	System.out.println( "      p -- Play" );	
	System.out.println( "      v -- View Highscores" );
	System.out.println( "      e -- Exit" );
	System.out.print( "\n" );
	System.out.println( "***** KAUN BANEGA CROREPATI *****" );
	charchoice = input.next().charAt( 0 );
	return charchoice;
}

static void startquestions(int start)
{
	questionclass questionobj = new questionclass();
	
	
	
	for( int i=start; i<questionobj.question.length; i++ )
	{
		System.out.println( questionobj.question[i] );
		System.out.print( "your ans: " );
		
		char charchoice = input.next().charAt(0);

		if( charchoice == questionobj.correctans[i] )
		{
			
			System.out.println( "correct answer !!!" );
			money += 2000; 
			System.out.println( "you won Rs2000" );
			System.out.println( "Total amount = Rs" +money+ "\n\n" );
		}
		
		else if( charchoice == 'h' )
		{
			System.out.println( "Select from following lifelines:" );
			if( fifty == 1 )
			{
			   System.out.println( "1 -- fifty-fifty" );
			}
			if( audiencepole == 1 )
			{
			   System.out.println( "2 -- Audience Pole" );
			}
			if( skipquestion == 1 )
			{
			   System.out.println( "3 -- Skip this Question" );
			}
			if( redeem == 1 )
			{
				System.out.println( "4 -- Redeem a lifeline" );
			}
			   int intchoice = input.nextInt();
			lifelines( intchoice , i );
		}
		
		else if( charchoice == 'q' )
		{
			System.out.println( "Total amount = Rs" +money+ "\n\n" );
			writing_scores();
			break; 
		}
		 
		else
		{
			System.out.println( "wrong answer !!! \n" );
			System.out.println( "Total amount = Rs" +money+ "\n\n" );
			writing_scores();
			break;
		} 		
	}
}




static void play()
{
	Scanner input = new Scanner(System.in); 
	System.out.print( "enter your name:- " );
    username = input.next();
    
	startquestions( 0 ); 
	
}

static void lifelines( int intchoice , int i )
{
  	switch( intchoice )
  	{
  	    case 1 : fifty( i );
  	             break;
  	    case 2 : audiencepole( i );
  	             break;
  	    case 3 : skipquestion( i+1 );
  	             break;
  	    case 4 : redeem( i );
                 break;         
  	}
}

static void redeem( int i )
{
	System.out.println( "which lifeline to redeem ?" );
	if( fifty == 0 )
	{
	   System.out.println( " 1 -- fifty-fifty" );
	}
	if( audiencepole == 0 )
	{
	   System.out.println( " 2 -- audience pole" );
	}
	if( skipquestion == 0 )
	{
	   System.out.println( " 3 -- skip question" );
	}
	System.out.println( " 4 -- no one" );
	System.out.print( "your choice: " );
	charchoice = input.next().charAt(0);
	
	if( charchoice == '1' )
	{
		fifty = 1;
		redeem = 0;
	}
	if( charchoice == '2' )
	{
		audiencepole = 1;
		redeem = 0;
	}
	if( charchoice == '3' )
	{
		skipquestion = 1;
		redeem = 0;
	}
	if( charchoice == '4' )
	{
		startquestions( i );
		
	}
}

static void fifty( int i )
{
	fifty = 0;
	System.out.println( questionobj.fifty[i] );
	System.out.print( "your ans: " );
	char charchoice = input.next().charAt(0);
	if( charchoice != questionobj.correctans[i] )
	{
		System.out.println( "wrong answer !!! \n" );
		System.out.println( "Total amount = Rs" +money+ "\n\n" );
		i = 0;
		writing_scores();
		
		maindisplay();
		
		
	}
}

static void audiencepole( int i )
{
	questionclass questionobj = new questionclass();
	
	if( questionobj.correctans[i] == '1' )
	{
		System.out.println( makerectangle( 10 ) );
		System.out.println( makerectangle( 10 ) + "1");		
		System.out.println( makerectangle( 10 ) + "\n");
		
		System.out.println( makerectangle( 8 ) );
		System.out.println( makerectangle( 8 ) + "2");
		System.out.println( makerectangle( 8 ) + "\n");
		
		System.out.println( makerectangle( 6 ) );
		System.out.println( makerectangle( 6 ) + "3");
		System.out.println( makerectangle( 6 ) + "\n");
		
		System.out.println( makerectangle( 4 ) );
		System.out.println( makerectangle( 4 ) + "4");
		System.out.println( makerectangle( 4 ) + "\n");
		
	}
	else if( questionobj.correctans[i] == '2' )
	{
		System.out.println( makerectangle( 4 ) );
		System.out.println( makerectangle( 4 ) + "1");		
		System.out.println( makerectangle( 4 ) + "\n");
		
		System.out.println( makerectangle( 10 ) );
		System.out.println( makerectangle( 10 ) + "2");
		System.out.println( makerectangle( 10 ) + "\n");
		
		System.out.println( makerectangle( 6 ) );
		System.out.println( makerectangle( 6 ) + "3");
		System.out.println( makerectangle( 6 ) + "\n");
		
		System.out.println( makerectangle( 2 ) );
		System.out.println( makerectangle( 2 ) + "4");
		System.out.println( makerectangle( 2 ) + "\n");
	}
	else if( questionobj.correctans[i] == '3' )
	{
		System.out.println( makerectangle( 2 ) );
		System.out.println( makerectangle( 2 ) + "1");		
		System.out.println( makerectangle( 2 ) + "\n");
		
		System.out.println( makerectangle( 6 ) );
		System.out.println( makerectangle( 6 ) + "2");
		System.out.println( makerectangle( 6 ) + "\n");
		
		System.out.println( makerectangle( 10 ) );
		System.out.println( makerectangle( 10 ) + "3");
		System.out.println( makerectangle( 10 ) + "\n");
		
		System.out.println( makerectangle( 4 ) );
		System.out.println( makerectangle( 4 ) + "4");
		System.out.println( makerectangle( 4 ) + "\n");
	}
	else if( questionobj.correctans[i] == '4' )
	{
		System.out.println( makerectangle( 2 ) );
		System.out.println( makerectangle( 2 ) + "1");		
		System.out.println( makerectangle( 2 ) + "\n");
		
		System.out.println( makerectangle( 6 ) );
		System.out.println( makerectangle( 6 ) + "2");
		System.out.println( makerectangle( 6 ) + "\n");
		
		System.out.println( makerectangle( 4 ) );
		System.out.println( makerectangle( 4 ) + "3");
		System.out.println( makerectangle( 4 ) + "\n");
		
		System.out.println( makerectangle( 10 ) );
		System.out.println( makerectangle( 10 ) + "4");
		System.out.println( makerectangle( 10 ) + "\n");
	}
	System.out.print( "your ans: " );
	audiencepole = 0;
	char charchoice = input.next().charAt(0);
	if( charchoice != questionobj.correctans[i] )
	{
		System.out.println( "wrong answer !!! \n" );
		System.out.println( "Total amount = Rs" +money+ "\n\n" );
		i = 0;
		writing_scores();
		maindisplay();
		
	}
	
}

static char makerectangle( int rows )
{ 
	char waste=' ';
	int cols=4,r,c;
	char a[][] = new char[rows][cols];
    
    for( r=0; r<rows; r++ )
    {
        for( c=0; c<cols; c++ )
        {

           a[r][c]='*';
        }
    }

    for( r=0; r<rows; r++ )
    {
        for( c=0; c<cols; c++ )
        {

           System.out.print( a[r][c] );
        } // System.out.println();
    }
    
    return waste;
}

static void skipquestion(int newstart)
{
	skipquestion = 0;
	startquestions( newstart );
}


static void viewhighscores()
{
	
}	
 
static void writing_scores()
{
	String filename = "highscores.txt";
	
	BufferedWriter bw = null;
	try
	{
	   FileWriter fw = new FileWriter( filename );
	
	   bw = new BufferedWriter( fw );
       
	   bw.write( username + "\t" + money );
	}
	catch( Exception e )
	{
		System.out.println( "Error writing to file " +filename );
	}
}
}