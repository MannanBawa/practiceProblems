//
//  model.h
//  ticTacToe
//
//  Created by Mannan Bawa on 10/29/18.
//  Copyright © 2018 Mannan Bawa. All rights reserved.
//

#ifndef model_h
#define model_h

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "Tile.h"

@interface Model : UIView

@property int moveCount;
@property NSMutableArray *Board;

//Resets the board, and sets move count to 0
-(void)resetGame;

//Reset the board, by creating a 4x4 NSMutableArray of Tiles
-(void)resetBoard;

//Add one to the move count
-(void) incrementMoveCount;

//Returns X or O based on current moveCount
-(NSString*)currentTurn;

//Given the location of the last move, checks if one of the game over conditions have been met
-(bool) isGameOverWithX:(int)xCoord Y:(int)yCoord;

//Checks if all four corners have the same marking on them
-(bool) checkFourCornerWin;

//Given the location of the last move, checks if that entire column has the same marking
-(bool) checkVerticalWinWithX:(int)xCoord Y:(int)yCoord;

//Given the location of the last move, checks if that entire row has the same marking
-(bool) checkHorizontalWinWithX:(int)xCoord Y:(int)yCoord;

//Checks if the diagonal going from the bottom-left tile to the top-right tile have the same marking
-(bool) checkForwardSlashDiagonal;

//Checks if the diagonal going from the top-left tile to the bottom-right tile have the same marking
-(bool) checkBackSlashDiagonal;

//Given the location of the last move, checks if any 2x2 squares of tiles with the same marking are completed
-(bool) checkSquareWinWithX:(int)xVal Y:(int)yVal;

//Helper for checkSquareWinWithX: Y: Given a tile location, returns a NSMutableArray of booleans indicating what directions contain other tiles that should be checked for marking with the following format:
// [CheckAbove?, CheckBelow?, CheckLeft?, CheckRight?]
-(NSMutableArray*) getValidDirectionsWithX:(int)xVal Y:(int)yVal;

#endif /* model_h */

@end
