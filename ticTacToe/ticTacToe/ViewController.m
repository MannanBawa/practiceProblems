//
//  ViewController.m
//  ticTacToe
//
//  Created by Mannan Bawa on 10/29/18.
//  Copyright © 2018 Mannan Bawa. All rights reserved.
//

#import "ViewController.h"
#import "Model.h"

@interface ViewController ()
@property (strong, nonatomic) IBOutlet UIView *superView;
@property (weak, nonatomic) IBOutlet UIView *headerView;
@property (weak, nonatomic) IBOutlet UILabel *currentPlayer;
@property (weak, nonatomic) IBOutlet UIButton *resetGameButton;
@property (weak, nonatomic) IBOutlet UIView *resetButtonBackground;


@end

@implementation ViewController

- (void)viewDidLoad {
    //Setup super properties
    [super viewDidLoad];
    _superView.backgroundColor = [UIColor lightGrayColor];
    
    //Setup properties
    _runningModel = [[Model alloc] init];
    _gameOver = false;
    _currentPlayer.text = _runningModel.currentTurn;
    
    //Display Model data
    [_runningModel resetBoard];
    [self displayBoard:_runningModel.Board];
}

- (IBAction)resetButtonPress:(id)sender {
    //Reset properties
    _gameOver = false;
    _currentPlayer.text = _runningModel.currentTurn;
    _resetButtonBackground.frame = CGRectMake(112, 569, 150, 40);
    _resetGameButton.frame = CGRectMake(-94, 5, 339, 30);
    [_resetGameButton setTitle:@"New Game" forState:UIControlStateNormal];
    
    //Reset and retreive Model data
    [_runningModel resetGame];
    NSMutableArray *newBoard = _runningModel.Board;
    [self displayBoard:newBoard];
}

-(void) displayBoard: (NSMutableArray*)boardToDisplay {
    NSUInteger numCols = [boardToDisplay count];
    for (int col = 0; col < numCols; col++) {
        NSMutableArray *thisCol = [boardToDisplay objectAtIndex:col];
        NSUInteger numRows = [thisCol count];
        for (int row = 0; row < numRows; row++) {
            Tile *thisTile = [thisCol objectAtIndex:row];
            thisTile.backgroundColor = [UIColor whiteColor];
            
            //Setup tap gesture recognizer, on tap, calls self.gotTapped
            thisTile.userInteractionEnabled = true;
            UITapGestureRecognizer *singleTouch = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(gotTapped:)];
            [thisTile addGestureRecognizer: singleTouch];
            
            //Add tile to view
            [self.view addSubview:thisTile];
        }
    }
}

- (void) gotTapped:(UITapGestureRecognizer*)recognizer {
    Tile* tappedTile = recognizer.view;
    
    //If game is still going, and tile is untouched
    if (tappedTile.isBlank && !_gameOver) {
        NSString* marking = self.runningModel.currentTurn;
        [tappedTile markTile:marking];
        [self updateCurrentPlayer];
        
        //Check if game is over after this move
        _gameOver = [_runningModel isGameOverWithX:tappedTile.xCoord Y:tappedTile.yCoord];
    }
    //If game is over, don't allow any moves, change reset button.
    if (_gameOver) {
        _resetButtonBackground.frame = CGRectMake(10, 569, 360, 40);
        _resetGameButton.frame = CGRectMake(-20, 5, 400, 30);
        [_resetGameButton setTitle:@"Game Over! Tap Here to Restart!" forState:UIControlStateNormal];
    }
}

-(void)updateCurrentPlayer {
    [_runningModel incrementMoveCount];
    _currentPlayer.text = _runningModel.currentTurn;
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
