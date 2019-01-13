
package sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayController implements Initializable {
    
        public int start = 0;
        
	@FXML Button button_one; 
	@FXML Button button_two;
	@FXML Button button_three;
	@FXML Button button_four;
	@FXML Button button_five;
	@FXML Button button_six;
	@FXML Button button_seven;
	@FXML Button button_eight;
	@FXML Button button_nine;
        @FXML Button button_zero;
        @FXML Button button_A;
        @FXML Button button_B;
        @FXML Button button_C;
        @FXML Button button_D;
        @FXML Button button_E;
        @FXML Button button_F;
	@FXML Canvas canvas;

	
	GameBoard gameboard;
	
	int player_selected_row;
	int player_selected_col;
        
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		gameboard = new GameBoard();
		
		GraphicsContext context = canvas.getGraphicsContext2D();
		
		drawOnCanvas(context);
		
		player_selected_row = 0;
		player_selected_col = 0;
               
                
                
	}

	
	public void drawOnCanvas(GraphicsContext context) {

		context.clearRect(0, 0, 850, 800);
		
		for(int row = 0; row<4; row++) {
			for(int col = 0; col<4; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                for(int row = 0; row<4; row++) {
			for(int col = 4; col<8; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.GREY);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                for(int row = 0; row<4; row++) {
			for(int col = 8; col<12; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                for(int row = 0; row<4; row++) {
			for(int col = 12; col<16; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.GREY);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                
                
                
                
                
		for(int row = 4; row<8; row++) {
			for(int col = 0; col<4; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.GREY);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}  
                
                
                for(int row = 4; row<8; row++) {
			for(int col = 4; col<8; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                for(int row = 4; row<8; row++) {
			for(int col = 8; col<12; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.GREY);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                for(int row = 4; row<8; row++) {
			for(int col = 12; col<16; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
		for(int row = 8; row<12; row++) {
			for(int col = 8; col<12; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}  
                
                for(int row = 8; row<12; row++) {
			for(int col = 0; col<4; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		} 
                
                for(int row = 8; row<12; row++) {
			for(int col = 4; col<8; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.GREY);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		} 
                
                for(int row = 8; row<12; row++) {
			for(int col = 8; col<12; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                for(int row = 8; row<12; row++) {
			for(int col = 12; col<16; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.GREY);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		} 
                
                
                for(int row = 12; row<16; row++) {
			for(int col = 0; col<4; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.GREY);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                for(int row = 12; row<16; row++) {
			for(int col = 4; col<8; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                for(int row = 12; row<16; row++) {
			for(int col = 8; col<12; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.GREY);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                for(int row = 12; row<16; row++) {
			for(int col = 12; col<16; col++) {
				int position_y = row * 50 + 2;
				int position_x = col * 50 + 2;
				int width = 46;
				context.setFill(Color.WHITE);
				context.fillRoundRect(position_x, position_y, width, width, 10, 10);
			}
		}
                
                
		context.setStroke(Color.RED);
		context.setLineWidth(5);
		context.strokeRoundRect(player_selected_col * 50 + 2, player_selected_row * 50 + 2, 46, 46, 10, 10);
                
		 int[][] initial = gameboard.getInitial();
		for(int row = 0; row<16; row++) {
			for(int col = 0; col<16; col++) {
				int position_y = row * 50 + 30;
				int position_x = col * 50 + 20;
				context.setFill(Color.BLACK);
				context.setFont(new Font(20));
				if(initial[row][col]!=12) {
					context.fillText(initial[row][col] + "", position_x, position_y);
				}
			}
		}

				 int[][] player = gameboard.getPlayer();
				for(int row = 0; row<16; row++) {
					for(int col = 0; col<16; col++) {
						int position_y = row * 50 + 30;
						int position_x = col * 50 + 20;
						// set the fill color to purple (you could set it to whatever you want)
						context.setFill(Color.PURPLE);
						// set the font, from a new font, constructed from the system one, with size 20
						context.setFont(new Font(22));
						// check if value of coressponding array position is not 0
						if(player[row][col]!=12) {
							context.fillText(player[row][col] + "", position_x, position_y);
						}
					}
				}


				if(gameboard.checkForSuccessGeneral() == true) {

					context.clearRect(0, 0, 800, 800);
					// set the fill color to green
					context.setFill(Color.BLACK);
					// set the font to 36pt
					context.setFont(new Font(36));
					// display SUCCESS text on the screen
					context.fillText("SUCCESS!", 425, 400);
				}


	}

	public void canvasMouseClicked() {
		canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				int mouse_x = (int) event.getX();
				int mouse_y = (int) event.getY();
                                
				player_selected_row = (int) (mouse_y / 50);
				player_selected_col = (int) (mouse_x / 50);

				drawOnCanvas(canvas.getGraphicsContext2D());
			}
		});
	}

	public void buttonOnePressed() {
		gameboard.modifyPlayer(1, player_selected_row, player_selected_col);

		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonTwoPressed() {
		gameboard.modifyPlayer(2, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonThreePressed() {
		gameboard.modifyPlayer(3, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonFourPressed() {
		gameboard.modifyPlayer(4, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonFivePressed() {
		gameboard.modifyPlayer(5, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
        
	public void buttonSixPressed() {
		gameboard.modifyPlayer(6, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}

	public void buttonSevenPressed() {
		gameboard.modifyPlayer(7, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	
	public void buttonEightPressed() {
		gameboard.modifyPlayer(8, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
	
	public void buttonNinePressed() {
		gameboard.modifyPlayer(9, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
        
        public void buttonZeroPressed() {
		gameboard.modifyPlayer(0, player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
        
        public void buttonAPressed() {
		gameboard.modifyPlayer('A', player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
        
        public void buttonBPressed() {
		gameboard.modifyPlayer('B', player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
        
        public void buttonCPressed() {
		gameboard.modifyPlayer('C', player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
        
        public void buttonDPressed() {
		gameboard.modifyPlayer('D', player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
        
        public void buttonEPressed() {
		gameboard.modifyPlayer('E', player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
        
        public void buttonFPressed() {
		gameboard.modifyPlayer('F', player_selected_row, player_selected_col);
		drawOnCanvas(canvas.getGraphicsContext2D());
	}
        
        
    @FXML
    private void handleButtonGiveUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml")); //muda para a proxima janela
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    @FXML
    private void handleButtonPause (ActionEvent event) throws IOException {
        if(start == 0){
            start = 1;
            canvas.setVisible(false);
        }else{
            start = 0;
            canvas.setVisible(true);
        }
    }
    
    public void buttonInfoPressed() {
        
        Stage popupwindow=new Stage();
        
        popupwindow.setResizable(false);
      
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Info");

        Label label1= new Label("Letter and corresponding numbers:\nA -> 65\nB -> 66\nC -> 67\nD -> 68\nE -> 69\nF -> 70\n");

        Button button1= new Button("Thanks");

        button1.setOnAction(e -> popupwindow.close());

        VBox layout= new VBox(5);

        layout.getChildren().addAll(label1, button1);

        layout.setAlignment(Pos.CENTER);

        Scene scene1= new Scene(layout, 300, 250);
      
        popupwindow.setScene(scene1);
      
        popupwindow.showAndWait();
    }
}
