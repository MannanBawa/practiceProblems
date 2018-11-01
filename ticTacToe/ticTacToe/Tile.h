//
//  Tile.h
//  ticTacToe
//
//  Created by Mannan Bawa on 10/30/18.
//  Copyright © 2018 Mannan Bawa. All rights reserved.
//

#ifndef Tile_h
#define Tile_h

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@interface Tile : UIImageView

@property NSString* marking;
@property int xCoord;
@property int yCoord;
@property BOOL isBlank;

@property UILabel* xLabel;
@property UILabel* oLabel;

//Init the tile knowing it's x and y position. This is effectively the only constructor that should be used.
-(id) initWithX:(int)xIn Y:(int)yIn;

//Mark the tile with the given input, setting it's label accordingly
-(void)markTile:(NSString*)marking;

#endif /* Tile_h */

@end
