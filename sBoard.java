//replaced all instances of the 2D array with the instances of the board instead
//Tri
public class sBoard {
	private String gameNum;
	public int[][] dB;
	public static boolean pMove;
	
	public sBoard() {
		//Board (NUMBERS INPUTTED ARE FOR TEST ALL CASES for BLACK)
		
		gameNum = "one";
		pMove = false;
		dB= new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 1, 2, 0, 0, 0 },
			{0, 0, 0, 2, 1, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 },
		};

	}
	public String getName() {
		return this.gameNum;
	}
	
	public int[][] getMatrix(){
		return this.dB;
	}
	
	public int getValue(int row, int column) {//Sean
		int value = this.dB[row][column];
		return value;
	}
	
	public void setValue(int row, int column, int v) {//Sean
		this.dB[row][column] = v;
	}
	public static boolean possibleMoves(sBoard b, Player p) {
		//get Player color 
		int color = p.getColor();
		int color1;
		boolean pMoves = false;
		if(color == 1)
			 color1 = 2;
		else 
			 color1 = 1;		
		
		int column = 0;
		int row = 0;
			
			
		//BLACK PLAYER
		if(color == 1) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {	
				 
				 switch(b.getValue(i,j)) {
				 	case 0:
						 break;
						 
					case 1:
						// Checks move down V2
						if( (b.getValue(i,j) == color) && (b.getValue(i+1, j) == color1) ){
									int n = 1;
									while(b.getValue(i+n,j) != color) {
										if(b.getValue(i+n, j) == color1) {
											n++;
										}
										else if(b.getValue(i+n, j) == 0){
											b.setValue(i+n,j,3);
											pMove = false;
											break;
										}
									}
						}
						
						//Checks move up
						if( (b.getValue(i,j) == color ) && (b.getValue(i-1, j) == color1) && i >= 2 ){ //Checks move up
								int n = 1;
									while(b.getValue(i-n, j) != color && n <= i) {
										if(b.getValue(i-n, j) == color1) {
											n++;
										}
										else if(b.getValue(i-n, j) == 0){
											b.setValue(i-n, j, 3);
											pMove = false;
											break;
										}
								
									}		
						}
						
						//Checks moves right
						if ((b.getValue(i, j) == color) && (b.getValue(i, j+1) == color1)){
							int n = 1;
							while(b.getValue(i, j+n) != color) {
								if(b.getValue(i, j+n) == color1) {
									n++;
								}
								
								else if(b.getValue(i, j+n) == 0){
									b.setValue(i, j+n, 3);;
									pMove = false;
									break;
									}
						
						
							}
						}
						
						//Checks move left
						if((b.getValue(i, j-1) == color) && (b.getValue(i, j-1) == color1)) {
							int n = 1;
							while(b.getValue(i, j-n) != color) {
								if(b.getValue(i, j-n) == color1) {
									n++;
								}
								
								else if(b.getValue(i, j-n) == 0){
									b.setValue(i, j-n, 3);
									pMove = false;
									break;
								}
						
							}
						}
						
						//checks down-right diagonal
						if(b.getValue(i, j) == color && b.getValue(i+1, j+1)==color1) {
				 			int n=1;
				 			while(b.getValue(i+n, j+n)!=color) {
				 				if (b.getValue(i+n, j+n)==color1){
				 					n++;
				 				}
				 				else if(b.getValue(i+n, j+n)==0) {
				 					b.setValue(i+n, j+n, 3);
				 					pMove = false;
				 					break;
				 				}
				 			}
				 			
						}
						
						 //checks down-left diagonal
						if(b.getValue(i+1, j-1)==color1 && b.getValue(i, j)==color) {
				 			int n=1;
				 			while(b.getValue(i+n, j-n)!=color) {
				 				if (b.getValue(i+n, j-n)==color1){
				 					n++;
				 				}
				 				else if(b.getValue(i+n, j-n)==0) {
				 					b.setValue(i+n, j-n, 3);;
				 					pMove = false;
				 					break;
				 				}
				 			
				 			}
				 		}
						
						//checks up-right diagonal
						if(b.getValue(i-1, j+1)==color1 && b.getValue(i, j)==color) {
				 			int n=1;
				 			while(b.getValue(i-n, j+n)!=color) {
				 				if (b.getValue(i-n, j+n)==color1){
				 					n++;
				 				}
				 				else if(b.getValue(i-n, j+n)==0) {
				 					b.setValue(i-n, j+n, 3);
				 					pMove = false;
				 					break;
				 				}
				 			
				 			}
				 		}
						
						//checks up-left diagonal
						if(b.getValue(i-1, j-1)==color1 && b.getValue(i, j)==color) {
				 			int n=1;
				 			while(b.getValue(i-n, j-n)!=color) {
				 				if (b.getValue(i-n, j-n)==color1){
				 					n++;
				 				}
				 				else if(b.getValue(i-n, j-n)==0) {
				 					b.setValue(i-n, j-n, 3);;
				 					pMove = false;
				 					break;
				 				}
				 			
				 			}
				 		}
						break;
					 
					case 2: 
						break;
				 }
				}
			}	 
		}
		
		
		
		//WHITE PLAYER
		if(color == 2) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					
						 switch(b.getValue(i, j)) {
						 	case 0:
						 		break;
						 		
						 	case 1:
						 		break;
						 
						 	case 2: 
								// Checks move down V2
								if( (b.getValue(i, j) == color) && (b.getValue(i+1, j) == color1) ){
								
			
											int n = 1;
											while(b.getValue(i+n, j) != color) {
												if(b.getValue(i+n, j) == color1) {
													n++;
												}
												else if(b.getValue(i+n, j) == 0){
													b.setValue(i+n, j, 3);;
													pMove = false;
													break;
												}
											}
								}
								
								//Checks move up
								if( (b.getValue(i, j) == color ) && (b.getValue(i-1, j) == color1) && i >= 0 ){ //Checks move up
										int n = 1;
											while(b.getValue(i-n, j) != color) {
												if(b.getValue(i-n, j) == color1) {
													n++;
												}
												else if(b.getValue(i-n, j) == 0){
													b.setValue(i-n, j, 3);
													pMove = false;
													break;
													}
										
										
									}
								}
								
								
								//Checks moves right
								if ((b.getValue(i, j) == color) && (b.getValue(i, j+1) == color1)){
									int n = 1;
									while(b.getValue(i, j+n) != color) {
										if(b.getValue(i, j+n) == color1) {
											n++;
										}
										else if(b.getValue(i, j+n) == 0){
											b.setValue(i, j+n, 3);;
											pMove = false;
											break;
										}
								
								
									}
								}
								
								//Checks move left
								if((b.getValue(i, j) == color) && (b.getValue(i, j-1) == color1)) {
									int n = 1;
									while(b.getValue(i, j-n) != color) {
										if(b.getValue(i, j-n) == color1) {
											n++;
										}
										else if(b.getValue(i, j-n) == 0){
											b.setValue(i, j-n, 3);;
											pMove = false;
											break;
											}
								
									}
								}
								
								//checks down-right diagonal
								if(b.getValue(i, j) == color && b.getValue(i+1, j+1)==color1) {
						 			int n=1;
						 			while(b.getValue(i+n, j+n)!=color) {
						 				if (b.getValue(i+n, j+n)==color1){
						 					n++;
						 				}
						 				else if(b.getValue(i+n, j+n)==0) {
						 					b.setValue(i+n, j+n, 3);;
						 					pMove = false;
						 					break;
						 				}
						 			}
						 			
								}
								
								 //checks down-left diagonal
								if(b.getValue(i+1, j-1)==color1 && b.getValue(i, j)==color) {
						 			int n=1;
						 			while(b.getValue(i+n, j-n)!=color) {
						 				if (b.getValue(i+n, j-n)==color1){
						 					n++;
						 				}
						 				else if(b.getValue(i+n, j-n)==0) {
						 					b.setValue(i+n, j-n, 3);;
						 					pMove = false;
						 					break;
						 				}
						 			}
						 		}
								
								//checks up-right diagonal
								if(b.getValue(i-1, j+1)==color1 && b.getValue(i, j)==color) {
						 			int n=1;
						 			while(b.getValue(i-n, j+n)!=color) {
						 				if (b.getValue(i-n, j+n)==color1){
						 					n++;
						 				}
						 				else if(b.getValue(i-n, j+n)==0) {
						 					b.setValue(i-n, j+n, 3);;
						 					pMove = false;
						 					break;
						 				}
						 			}
						 		}
								
								//checks up-left diagonal
								if(b.getValue(i-1, j-1)==color1 && b.getValue(i, j)==color) {
						 			int n=1;
						 			while(b.getValue(i-n, j-n)!=color) {
						 				if (b.getValue(i-n, j-n)==color1){
						 					n++;
						 				}
						 				else if(b.getValue(i-n, j-n)==0) {
						 					b.setValue(i-n, j-n, 3);;
						 					pMove = false;
						 					break;
						 				}
						 			
						 			}
						 		}
								break;
							 
						 }
				}
			}
		}
		
		//Might need a second look
		//USED TO SHOW ARRAY FOR TESTING
		for( row = 0; row < 7; row++ ){
		  for(column = 0; column < 7; column++ ){
		    System.out.print(Integer.toString(b.getValue(row, column))+"  ");
		  }
		  System.out.print("\n"); 
		}
		//END OF TEST STATEMENTS
	return pMove;	
	}
	
	public static void CapturePiece(sBoard board, Player player) {
		//Get player color
        int color1 = player.getColor();
        int color2;
        if (color1 == 1)
        	color2 = 2;
        else 
            color2 = 1;
        int column = 0;
        int row = 0;
        //end get player color

        //BLACK PLAYER
        if (color1 == 1) {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                	switch(board.getValue(i, j)) {
				 		case 0:
				 			break;
						 
				 		case 1:
				 			break;
				 			
				 		case 2:
				 			break;
				 			
				 		case 3:
				 			//Captures UP from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i-1, j)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i-x, j)==color2) {
				 					if(board.getValue(i-x, j) == color2) {
				 						board.setValue(i-x, j, color1);
				 						x++;
				 					}
				 					else if(board.getValue(i-x, j)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i+1, j)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i+x, j)==color2) {
				 					if(board.getValue(i+x, j) == color2) {
				 						board.setValue(i+x, j, color1);
				 						x++;
				 					}
				 					else if(board.getValue(i+x, j)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures LEFT from 3
				 			if(board.getValue(i,j)==3 && board.getValue(i, j-1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i, j-x)==color2) {
				 					if(board.getValue(i, column) == color2) {
				 						board.setValue(i, j-x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i, j-x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures RIGHT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i, j+1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i, j+x)==color2) {
				 					if(board.getValue(i, j+x) == color2) {
				 						board.setValue(i, j+x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i, j+x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures UP-LEFT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i-1, j-1)==color2) {
				 				
				 				//This part was NOT commented out, not sure if intentional or not.  
				 				//board[i][j]=color1;
				 				
				 				int x = 1;
				 				while(board.getValue(i-x, j-x)==color2) {
				 					if(board.getValue(i-x, j-x) == color2) {
				 						board.setValue(i-x, j-x, color1);
				 						x++;
				 					}
				 					else if(board.getValue(i-x, j-x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN-RIGHT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i+1, j+1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i+x, j+x)==color2) {
				 					if(board.getValue(i+x, j+x) == color2) {
				 						board.setValue(i+x, j+x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i+x, j+x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures UP-RIGHT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i-1, j+1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i-x, j+x)==color2) {
				 					if(board.getValue(i-x, j+x) == color2) {
				 						board.setValue(i-x, j+x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i-x, j+x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN-LEFT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i+1, j-1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i+x, j-x)==color2) {
				 					if(board.getValue(i+x, j-x) == color2) {
				 						board.setValue(i+x, j-x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i+x, j-x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			break;
                	}
                }
            }
        }
        
        //WHITE PLAYER
        if (color1 == 2) {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                	switch(board.getValue(i, j)) {
				 		case 0:
				 			break;
						 
				 		case 1:
				 			break;
				 			
				 		case 2:
				 			break;
				 			
				 		case 3:
				 			//Captures UP from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i-1, j)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i-x, j)==color2) {
				 					if(board.getValue(i-x, j) == color2) {
				 						board.setValue(i-x, j, color1);
				 						x++;
				 					}
				 					else if(board.getValue(i-x, j)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i+1, j)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i+x, j)==color2) {
				 					if(board.getValue(i+x, j) == color2) {
				 						board.setValue(i+x, j, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i+x, j)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures LEFT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i, j-1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i, j-x)==color2) {
				 					if(board.getValue(i, j-x) == color2) {
				 						board.setValue(i, j-x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i, j-x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures RIGHT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i, j+1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i, j+x)==color2) {
				 					if(board.getValue(i, j+x) == color2) {
				 						board.setValue(i, j+x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i, j+x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures UP-LEFT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i-1, j-1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i-x, j-x)==color2) {
				 					if(board.getValue(i-x, j-x) == color2) {
				 						board.setValue(i-x, j-x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i-x, j-x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN-RIGHT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i+1, j+1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i+x, j+x)==color2) {
				 					if(board.getValue(i+x, j+x) == color2) {
				 						board.setValue(i+x, j+x, color1);
				 						x++;
				 					}
				 					else if(board.getValue(i+x, j+x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures UP-RIGHT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i-1, j+1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i-x, j+x)==color2) {
				 					if(board.getValue(i-x, j+x) == color2) {
				 						board.setValue(i-x, j+x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i-x, j+x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			
				 			//Captures DOWN-LEFT from 3
				 			if(board.getValue(i, j)==3 && board.getValue(i+1, j-1)==color2) {
				 				//board[i][j]=color1;
				 				int x = 1;
				 				while(board.getValue(i+x, j-x)==color2) {
				 					if(board.getValue(i+x, j-x) == color2) {
				 						board.setValue(i+x, j-x, color1);;
				 						x++;
				 					}
				 					else if(board.getValue(i+x, j-x)==color1) {
				 						break;
				 					}
				 				}
				 			}
				 			if (board.getValue(i, j) == 3) {
				 				board.setValue(i, j, color1);;
				 			}
				 			break;
                	}
                }
            }
        }
        
        //Test array for capturing piece
        for( row = 0; row < 7; row++ ){
              for(column = 0; column < 7; column++ ){
            	  System.out.print(Integer.toString(board.getValue(row, column))+"  ");
              }
              System.out.print("\n"); 
        }
        System.out.print("\n");
        //end test array
	}
}
	
//deleted a }