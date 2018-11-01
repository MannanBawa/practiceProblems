//
//  Model.m
//  ticTacToe
//
//  Created by Mannan Bawa on 10/29/18.
//  Copyright © 2018 Mannan Bawa. All rights reserved.
//

#import "Model.h"

@implementation Model

-(id) init {
    [self resetGame];
    return self;
}

- (void)resetGame {
    _moveCount = 0;
    [self resetBoard];
}

- (void)resetBoard {
    NSMutableArray *colOne;
    Tile *colOneRowOne = [[Tile alloc] initWithX:0 Y:0];
    Tile *colOneRowTwo = [[Tile alloc] initWithX:0 Y:1];
    Tile *colOneRowThree = [[Tile alloc] initWithX:0 Y:2];
    Tile *colOneRowFour = [[Tile alloc] initWithX:0 Y:3];
    colOne = [NSMutableArray arrayWithObjects:colOneRowOne, colOneRowTwo, colOneRowThree, colOneRowFour, nil];
    
    NSMutableArray *colTwo;
    Tile *colTwoRowOne = [[Tile alloc] initWithX:1 Y:0];
    Tile *colTwoRowTwo = [[Tile alloc] initWithX:1 Y:1];
    Tile *colTwoRowThree = [[Tile alloc] initWithX:1 Y:2];
    Tile *colTwoRowFour = [[Tile alloc] initWithX:1 Y:3];
    colTwo = [NSMutableArray arrayWithObjects:colTwoRowOne, colTwoRowTwo, colTwoRowThree, colTwoRowFour, nil];
    
    NSMutableArray *colThree;
    Tile *colThreeRowOne = [[Tile alloc] initWithX:2 Y:0];
    Tile *colThreeRowTwo = [[Tile alloc] initWithX:2 Y:1];
    Tile *colThreeRowThree = [[Tile alloc] initWithX:2 Y:2];
    Tile *colThreeRowFour = [[Tile alloc] initWithX:2 Y:3];
    colThree = [NSMutableArray arrayWithObjects:colThreeRowOne, colThreeRowTwo, colThreeRowThree, colThreeRowFour, nil];
    
    NSMutableArray *colFour;
    Tile *colFourRowOne = [[Tile alloc] initWithX:3 Y:0];
    Tile *colFourRowTwo = [[Tile alloc] initWithX:3 Y:1];
    Tile *colFourRowThree = [[Tile alloc] initWithX:3 Y:2];
    Tile *colFourRowFour = [[Tile alloc] initWithX:3 Y:3];
    colFour = [NSMutableArray arrayWithObjects:colFourRowOne, colFourRowTwo, colFourRowThree, colFourRowFour, nil];
    
    _Board = [NSMutableArray arrayWithObjects:colOne, colTwo, colThree, colFour, nil];
}

- (NSMutableArray*) getBoard {
    return self.Board;
}

- (NSString*)currentTurn {
    if (_moveCount % 2) { return @"O"; }
    return @"X";
}

-(void) incrementMoveCount {
    _moveCount = _moveCount + 1;
}

-(bool) isGameOverWithX:(int)xCoord Y:(int)yCoord {
    //If 7 moves haven't occured, a single player hasn't made 4 moves, so no win condition is possible
    if (_moveCount < 7) {
        return false;
    }
    //If 16 moves have been made, then the board is full and no winner has been found.
    if (_moveCount == 16) {
        return true;
    }
    //If any of the win conditions defined in the header are met, return true, else false.
    return (
            (self.checkFourCornerWin) ||
            [self checkVerticalWinWithX:xCoord Y:yCoord] ||
            [self checkHorizontalWinWithX:xCoord Y:yCoord] ||
            self.checkForwardSlashDiagonal ||
            self.checkBackSlashDiagonal ||
            [self checkSquareWinWithX:xCoord Y:yCoord]
            );
}
    
-(bool) checkFourCornerWin {
    NSMutableArray* colOne = [_Board objectAtIndex:0];
    NSMutableArray* colFour = [_Board objectAtIndex:3];
    
    Tile* topLeft = [colOne objectAtIndex:0];
    Tile* bottomLeft = [colOne objectAtIndex:3];
    
    Tile* topRight = [colFour objectAtIndex:0];
    Tile* bottomRight = [colFour objectAtIndex:3];
    
    if (![topLeft.marking  isEqual: @""] && ![topRight.marking  isEqual: @""] && ![bottomLeft.marking  isEqual: @""] && ![bottomRight.marking  isEqual: @""]) {
        if ([topLeft.marking isEqual:topRight.marking] && [topLeft.marking isEqual:bottomRight.marking] && [topLeft.marking isEqual:bottomLeft.marking]) {
            return true;
        } else return false;
    } else return false;
    return false;
}

-(bool) checkVerticalWinWithX:(int)xCoord Y:(int)yCoord {
    
    NSMutableArray* thisCol = [_Board objectAtIndex:xCoord];
    Tile* thisTile = [thisCol objectAtIndex:yCoord];
    NSString* thisMarking = thisTile.marking;
    
    for (int i = 0; i < [thisCol count]; i++) {
        Tile* tileToCheck = [thisCol objectAtIndex:i];
        if (tileToCheck.marking != thisMarking) {
            return false;
        }
    }
    return true;
}

-(bool) checkHorizontalWinWithX:(int)xCoord Y:(int)yCoord {
    
    NSMutableArray* thisCol = [_Board objectAtIndex:xCoord];
    Tile* thisTile = [thisCol objectAtIndex:yCoord];
    NSString* thisMarking = thisTile.marking;
    
    for (int i = 0; i < [_Board count]; i++) {
        NSMutableArray* colToCheck= [_Board objectAtIndex:i];
        Tile* tileToCheck = [colToCheck objectAtIndex:yCoord];
        if (tileToCheck.marking != thisMarking) {
            return false;
        }
    }
    return true;
}

-(bool) checkForwardSlashDiagonal {
    
    NSUInteger numCols = [_Board count];
    NSMutableArray* thisCol = [_Board objectAtIndex:0];
    NSUInteger numRows = [thisCol count];
    
    int colCounter = 0;
    int rowCounter = numRows - 1;
    
    Tile* bottomLeftTile = [thisCol objectAtIndex:rowCounter];
    NSString* thisMarking = bottomLeftTile.marking;
    
    if ([thisMarking  isEqual: @""]) {
        return false;
    }
    
    //Loop: Continously checks tiles to the top-right of previous tile, starting at bottom left tile
    while (colCounter < numCols && rowCounter < numRows) {
        NSMutableArray* colToCheck = [_Board objectAtIndex:colCounter];
        Tile* tileToCheck = [colToCheck objectAtIndex:rowCounter];
        
        
        if (tileToCheck.marking != thisMarking) {
            return false;
        }
        colCounter++;
        rowCounter--;
    }
    return true;
}

-(bool) checkBackSlashDiagonal {
    
    NSUInteger numCols = [_Board count];
    NSMutableArray* thisCol = [_Board objectAtIndex:0];
    NSUInteger numRows = [thisCol count];
    
    int colCounter = 0;
    int rowCounter = 0;
    
    Tile* topLeftTile = [thisCol objectAtIndex:rowCounter];
    NSString* thisMarking = topLeftTile.marking;
    
    if ([thisMarking  isEqual: @""]) {
        return false;
    }
    
     //Loop: Continously checks tiles to the bottom-right of previous tile, starting at top left tile
    while (colCounter < numCols && rowCounter < numRows) {
        NSMutableArray* colToCheck = [_Board objectAtIndex:colCounter];
        Tile* tileToCheck = [colToCheck objectAtIndex:rowCounter];
        
        
        if (tileToCheck.marking != thisMarking) {
            return false;
        }
        colCounter++;
        rowCounter++;
    }
    return true;
}

-(bool) checkSquareWinWithX:(int)xVal Y:(int)yVal {
    
    NSMutableArray* thisCol = [_Board objectAtIndex:xVal];
    Tile* thisTile = [thisCol objectAtIndex:yVal];
    NSString* thisMarking = thisTile.marking;
    
    if ([thisMarking  isEqual: @""]) {
        return false;
    }
    
    NSMutableArray* tilesToCheck = [self getValidDirectionsWithX:xVal Y:yVal];
    
    //check Above if possible
    if ([[tilesToCheck objectAtIndex:0]  isEqual: @1]) {
        Tile* tileAbove = [thisCol objectAtIndex:yVal - 1];
        
        //If above tile has same marking
        if (tileAbove.marking == thisMarking) {
            
            //If you can check left
            if ([[tilesToCheck objectAtIndex:2]  isEqual: @1]) {
                NSMutableArray* leftCol = [_Board objectAtIndex:xVal - 1];
                Tile* tileLeft = [leftCol objectAtIndex:yVal];
                
                //If left marking also matches, check top-left
                if (tileLeft.marking == thisMarking) {
                    Tile* tileTopLeft = [leftCol objectAtIndex:yVal - 1];
                    
                    if (tileTopLeft.marking == thisMarking) {
                        return true;
                    }
                }
            }
            
            //If you can check right
            if ([[tilesToCheck objectAtIndex:3]  isEqual: @1]) {
                NSMutableArray* rightCol = [_Board objectAtIndex:xVal + 1];
                Tile* tileRight = [rightCol objectAtIndex:yVal];
                
                //If right marking also matches, check top-right
                if (tileRight.marking == thisMarking) {
                    Tile* tileTopRight = [rightCol objectAtIndex:yVal - 1];
                    
                    if (tileTopRight.marking == thisMarking) {
                        return true;
                    }
                }
            }
        }
    }
    
    //Check below if possible
    if ([[tilesToCheck objectAtIndex:1]  isEqual: @1]) {
        Tile* tileBelow = [thisCol objectAtIndex:yVal + 1];
        
        //If above tile has same marking
        if (tileBelow.marking == thisMarking) {
            
            //If you can check left
            if ([[tilesToCheck objectAtIndex:2]  isEqual: @1]) {
                NSMutableArray* leftCol = [_Board objectAtIndex:xVal - 1];
                Tile* tileLeft = [leftCol objectAtIndex:yVal];
                
                //If left marking also matches, check bottom-left
                if (tileLeft.marking == thisMarking) {
                    Tile* tileBottomLeft = [leftCol objectAtIndex:yVal + 1];
                    
                    if (tileBottomLeft.marking == thisMarking) {
                        return true;
                    }
                }
            }
            
            //If you can check right
            if ([[tilesToCheck objectAtIndex:3]  isEqual: @1]) {
                NSMutableArray* rightCol = [_Board objectAtIndex:xVal + 1];
                Tile* tileRight = [rightCol objectAtIndex:yVal];
                
                //If right marking also matches, check top-right
                if (tileRight.marking == thisMarking) {
                    Tile* tileBottomRight = [rightCol objectAtIndex:yVal + 1];
                    
                    if (tileBottomRight.marking == thisMarking) {
                        return true;
                    }
                }
            }
        }
    }
    return false;
}

-(NSMutableArray*) getValidDirectionsWithX:(int)xVal Y:(int)yVal {
    
    NSMutableArray *outputArray;
    
    bool checkAbove = true;
    bool checkBelow = true;
    bool checkLeft = true;
    bool checkRight = true;
    
    if (yVal == 0) {
        checkAbove = false;
    }
    
    if (yVal == 3) {
        checkBelow = false;
    }
    
    if (xVal == 0) {
        checkLeft = false;
    }
    
    if (xVal == 3) {
        checkRight = false;
    }
    outputArray =[NSMutableArray arrayWithObjects: @(checkAbove), @(checkBelow), @(checkLeft), @(checkRight), nil];
    return outputArray;
}

@end

