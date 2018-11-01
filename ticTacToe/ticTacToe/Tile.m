//
//  Tile.m
//  ticTacToe
//
//  Created by Mannan Bawa on 10/30/18.
//  Copyright © 2018 Mannan Bawa. All rights reserved.
//

#import "Tile.h"
#import "Model.h"
#import "ViewController.h"

@implementation Tile

- (id) init {
    self.marking = @"";
    self.isBlank = TRUE;
    return self;
}

-(id) initWithX:(int)xIn Y:(int)yIn; {
    //Setup properties
    self.marking = @"";
    self.isBlank = TRUE;
    self.xCoord = xIn;
    self.yCoord = yIn;
    self.backgroundColor = [UIColor whiteColor];
    self = [super initWithFrame:CGRectMake( (90 * self.xCoord) + 10, (90 * self.yCoord) + 200, 85, 85)];
    
    //Setup xLabel properties
    _xLabel = [[UILabel alloc] initWithFrame:CGRectMake(22, 20, 50, 50)];
    _xLabel.text = @"X";
    _xLabel.textColor = [UIColor blackColor];
    [_xLabel setFont:[UIFont fontWithName: @"Trebuchet MS" size: 72.0f]];
    
    //Setup oLabel properties
    _oLabel = [[UILabel alloc] initWithFrame:CGRectMake(18.5, 8.5, 70, 70)];
    _oLabel.text = @"O";
    _oLabel.textColor = [UIColor blackColor];
    [_oLabel setFont:[UIFont fontWithName: @"Trebuchet MS" size: 72.0f]];
    
    //Remove from super for reset condition, just to be safe.
    [_xLabel removeFromSuperview];
    [_oLabel removeFromSuperview];
    
    return self;
}


- (void) markTile:(NSString*)marking {
    if (_isBlank) {
        self.marking = marking;
        self.isBlank = FALSE;
        
        if ([marking  isEqual: @"X"]) {
            [self addSubview:_xLabel];
        } else if ([marking  isEqual: @"O"]) {
            [self addSubview:_oLabel];
        }
    }
}

@end
