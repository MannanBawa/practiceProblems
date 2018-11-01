//
//  ViewController.h
//  ticTacToe
//
//  Created by Mannan Bawa on 10/29/18.
//  Copyright © 2018 Mannan Bawa. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Model.h"

@interface ViewController : UIViewController

@property Model* runningModel;
@property bool gameOver;

//Takes in a NSMutable Array, displays it by creating a UIView square for each Tile in the Board
-(void) displayBoard:(NSMutableArray*)boardToDisplay;

//When a tile gets tapped, marks that tile with an X or O, based on the current Turn (retreived from Model)
- (void) gotTapped:(UITapGestureRecognizer*)recognizer;

//Updates Model: switching players, and displaying the current player
-(void)updateCurrentPlayer;

@end

