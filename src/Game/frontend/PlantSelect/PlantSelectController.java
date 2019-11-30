package Game.frontend.PlantSelect;

import Game.backend.Exceptions.NoSlotLeftException;
import Game.backend.Plants.Barrier.TallNut;
import Game.backend.Plants.Barrier.WallNut;
import Game.backend.Plants.DynamicPlants.Bomb.Jalapeno;
import Game.backend.Plants.DynamicPlants.Bomb.PotatoMine;
import Game.backend.Plants.DynamicPlants.Collector.Sunflower;
import Game.backend.Plants.DynamicPlants.Collector.TwinSunflower;
import Game.backend.Plants.DynamicPlants.Shooter.*;
import Game.backend.User.CurrentUser;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PlantSelectController
{
	private Stage primaryStage;

	@FXML
	private ImageView op0;

	@FXML
	private ImageView op1;

	@FXML
	private ImageView op2;

	@FXML
	private ImageView op3;

	@FXML
	private ImageView op4;

	@FXML
	private ImageView op5;

	@FXML
	private ImageView op6;

	@FXML
	private ImageView op7;

	@FXML
	private ImageView op8;

	@FXML
	private ImageView op9;

	@FXML
	private ImageView op10;

	@FXML
	private ImageView slot1;

	@FXML
	private ImageView slot2;

	@FXML
	private ImageView slot3;

	@FXML
	private  ImageView slot4;

	@FXML
	private ImageView slot5;

	@FXML
	private ImageView slot6;

	private boolean[] plants;
	private boolean[] slots = new boolean[6];
	private LinkedHashMap<Integer, Integer> selected;

	void setPrimaryStage(Stage primaryStage)
	{
		for(int i=0;i<6;i++)
			slots[i] = false;
		this.primaryStage = primaryStage;
		selected = new LinkedHashMap<>();
		op0.setImage(new Image(TallNut.getCostImage()));
		op1.setImage(new Image(WallNut.getCostImage()));
		op2.setImage(new Image(Jalapeno.getCostImage()));
		op3.setImage(new Image(PotatoMine.getCostImage()));
		op4.setImage(new Image(Sunflower.getCostImage()));
		op5.setImage(new Image(TwinSunflower.getCostImage()));
		op6.setImage(new Image(Firey.getCostImage()));
		op7.setImage(new Image(Frosty.getCostImage()));
		op8.setImage(new Image(Gun.getCostImage()));
		op9.setImage(new Image(PeaShooter.getCostImage()));
		op10.setImage(new Image(Repeater.getCostImage()));
		plants = CurrentUser.getUser().getPlantUnlocked();
		boolean[] temp = new boolean[11];
		System.arraycopy(plants, 0, temp, 0, 11);
		plants = temp;
		setOpacity();
	}

	private void setOpacity() {
		if(!plants[0])
			op0.setOpacity(0.5);
		else
			op0.setOpacity(1);
		if(!plants[1])
			op1.setOpacity(0.5);
		else
			op1.setOpacity(1);
		if(!plants[2])
			op2.setOpacity(0.5);
		else
			op2.setOpacity(1);
		if(!plants[3])
			op3.setOpacity(0.5);
		else
			op3.setOpacity(1);
		if(!plants[4])
			op4.setOpacity(0.5);
		else
			op4.setOpacity(1);
		if(!plants[5])
			op5.setOpacity(0.5);
		else
			op5.setOpacity(1);
		if(!plants[6])
			op6.setOpacity(0.5);
		else
			op6.setOpacity(1);
		if(!plants[7])
			op7.setOpacity(0.5);
		else
			op7.setOpacity(1);
		if(!plants[8])
			op8.setOpacity(0.5);
		else
			op8.setOpacity(1);
		if(!plants[9])
			op9.setOpacity(0.5);
		else
			op9.setOpacity(1);
		if(!plants[10])
			op10.setOpacity(0.5);
		else
			op10.setOpacity(1);
	}

	@FXML
	private void backClick() throws Exception
	{
		Game.frontend.LevelSelect.LevelSelect.getInstance().run(primaryStage);
	}

	@FXML
	private void shopClick() throws Exception
	{
		Game.frontend.Shop.Shop.getInstance().run(primaryStage);
	}

	@FXML
	private void playClick() throws Exception
	{
//		for(Map.Entry e: selected.entrySet())
//			System.out.println(e.getKey()+" "+e.getValue());
		CurrentUser.getUser().setSelectedPlants(selected);
		Game.frontend.GameWindow.GameWindow.getInstance().run(primaryStage);
	}

	private void fillSlot(Image image) throws NoSlotLeftException
	{
		if(!slots[0]) {
			slot1.setImage(image);
			slots[0] = true;
		}
		else if(!slots[1]) {
			slot2.setImage(image);
			slots[1] = true;
		}
		else if(!slots[2]) {
			slot3.setImage(image);
			slots[2] = true;
		}
		else if(!slots[3]) {
			slot4.setImage(image);
			slots[3] = true;
		}
		else if(!slots[4]) {
			slot5.setImage(image);
			slots[4] = true;
		}
		else if(!slots[5]) {
			slot6.setImage(image);
			slots[5] = true;
		}
		else {
			throw new NoSlotLeftException("No slot available");
		}
	}

	@FXML
	private void op10Click(MouseEvent mouseEvent) {
		if(plants[10]) {
			try {
				plants[10] = false;
				op10.setOpacity(0.5);
				selected.put(10,0);
				fillSlot(op10.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[10] = true;
				op10.setOpacity(1);
				selected.remove(10);
			}
		}
	}

	@FXML
	private void op9Click(MouseEvent mouseEvent) {
		if(plants[9]) {
			try {
				plants[9] = false;
				op9.setOpacity(0.5);
				selected.put(9,0);
				fillSlot(op9.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[9] = true;
				op9.setOpacity(1);
				selected.remove(9);
			}
		}
	}

	@FXML
	private void op8Click(MouseEvent mouseEvent) {
		if(plants[8]) {
			try {
				plants[8] = false;
				op8.setOpacity(0.5);
				selected.put(8,0);
				fillSlot(op8.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[8] = true;
				op8.setOpacity(1);
				selected.remove(8);
			}
		}
	}

	@FXML
	private void op7Click(MouseEvent mouseEvent) {
		if(plants[7]) {
			try {
				plants[7] = false;
				op7.setOpacity(0.5);
				selected.put(7,0);
				fillSlot(op7.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[7] = true;
				op7.setOpacity(1);
				selected.remove(7);
			}
		}
	}

	@FXML
	private void op6Click(MouseEvent mouseEvent) {
		if(plants[6]) {
			try {
				plants[6] = false;
				op6.setOpacity(0.5);
				selected.put(6,0);
				fillSlot(op6.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[6] = true;
				selected.remove(6);
				op6.setOpacity(1);
			}
		}
	}

	@FXML
	private void op5Click(MouseEvent mouseEvent) {
		if(plants[5]) {
			try {
				plants[5] = false;
				op5.setOpacity(0.5);
				selected.put(5,0);
				fillSlot(op5.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[5] = true;
				selected.remove(5);
				op5.setOpacity(1);
			}
		}
	}

	@FXML
	private void op4Click(MouseEvent mouseEvent) {
		if(plants[4]) {
			try {
				plants[4] = false;
				op4.setOpacity(0.5);
				selected.put(4,0);
				fillSlot(op4.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[4] = true;
				op4.setOpacity(1);
				selected.remove(4);
			}
		}
	}

	@FXML
	private void op3Click(MouseEvent mouseEvent) {
		if(plants[3]) {
			try {
				selected.put(3,0);
				plants[3] = false;
				op3.setOpacity(0.5);
				fillSlot(op3.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[3] = true;
				op3.setOpacity(1);
				selected.remove(3);
			}
		}
	}

	@FXML
	private void op2Click(MouseEvent mouseEvent) {
		if(plants[2]) {
			try {
				selected.put(2,0);
				plants[2] = false;
				op2.setOpacity(0.5);
				fillSlot(op2.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[2] = true;
				op2.setOpacity(1);
				selected.remove(2);
			}
		}
	}

	@FXML
	private void op1Click(MouseEvent mouseEvent) {
		if(plants[1]) {
			try {
				selected.put(1,0);
				plants[1] = false;
				op1.setOpacity(0.5);
				fillSlot(op1.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[1] = true;
				op1.setOpacity(1);
				selected.remove(1);
			}
		}
	}

	@FXML
	private void op0Click(MouseEvent mouseEvent) {
		if(plants[0]) {
			try {
				selected.put(0,0);
				plants[0] = false;
				op0.setOpacity(0.5);
				fillSlot(op0.getImage());
			}
			catch(NoSlotLeftException e) {
				plants[0] = true;
				op0.setOpacity(1);
				selected.remove(0);
			}
		}
	}

	@FXML
	private void slot6Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot6.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			selected.remove(0);
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op1.getImage() == slot6.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(1);
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op2.getImage() == slot6.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(2);
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op3.getImage() == slot6.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			slot6.setImage(null);
			selected.remove(3);
			slots[5] = false;
		}
		else if (op4.getImage() == slot6.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			slot6.setImage(null);
			selected.remove(4);
			slots[5] = false;
		}
		else if (op5.getImage() == slot6.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			slot6.setImage(null);
			selected.remove(5);
			slots[5] = false;
		}
		else if (op6.getImage() == slot6.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			selected.remove(6);
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op7.getImage() == slot6.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			selected.remove(7);
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op8.getImage() == slot6.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			selected.remove(8);
			slot6.setImage(null);
			slots[5] = false;
		}
		else if (op9.getImage() == slot6.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			slot6.setImage(null);
			selected.remove(9);
			slots[5] = false;
		}
		else if (op10.getImage() == slot6.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			selected.remove(10);
			slot6.setImage(null);
			slots[5] = false;
		}
	}

	@FXML
	private void slot5Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot5.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			selected.remove(0);
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op1.getImage() == slot5.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(1);
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op2.getImage() == slot5.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(2);
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op3.getImage() == slot5.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			selected.remove(3);
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op4.getImage() == slot5.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			selected.remove(4);
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op5.getImage() == slot5.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			selected.remove(5);
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op6.getImage() == slot5.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			slot5.setImage(null);
			selected.remove(6);
			slots[4] = false;
		}
		else if (op7.getImage() == slot5.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			selected.remove(7);
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op8.getImage() == slot5.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			slot5.setImage(null);
			selected.remove(8);
			slots[4] = false;
		}
		else if (op9.getImage() == slot5.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			selected.remove(9);
			slot5.setImage(null);
			slots[4] = false;
		}
		else if (op10.getImage() == slot5.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			slot5.setImage(null);
			selected.remove(10);
			slots[4] = false;
		}
	}

	@FXML
	private void slot4Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot4.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			selected.remove(0);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op1.getImage() == slot4.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(1);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op2.getImage() == slot4.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(2);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op3.getImage() == slot4.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			selected.remove(3);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op4.getImage() == slot4.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			selected.remove(4);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op5.getImage() == slot4.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			selected.remove(5);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op6.getImage() == slot4.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			selected.remove(6);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op7.getImage() == slot4.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			selected.remove(7);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op8.getImage() == slot4.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			selected.remove(8);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op9.getImage() == slot4.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			selected.remove(9);
			slot4.setImage(null);
			slots[3] = false;
		}
		else if (op10.getImage() == slot4.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			slot4.setImage(null);
			selected.remove(10);
			slots[3] = false;
		}
	}

	@FXML
	private void slot3Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot3.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			selected.remove(0);
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op1.getImage() == slot3.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(1);
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op2.getImage() == slot3.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			slot3.setImage(null);
			selected.remove(2);
			slots[2] = false;
		}
		else if (op3.getImage() == slot3.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			slot3.setImage(null);
			selected.remove(3);
			slots[2] = false;
		}
		else if (op4.getImage() == slot3.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			slot3.setImage(null);
			selected.remove(4);
			slots[2] = false;
		}
		else if (op5.getImage() == slot3.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			selected.remove(5);
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op6.getImage() == slot3.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			selected.remove(6);
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op7.getImage() == slot3.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			selected.remove(7);
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op8.getImage() == slot3.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			selected.remove(8);
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op9.getImage() == slot3.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			selected.remove(9);
			slot3.setImage(null);
			slots[2] = false;
		}
		else if (op10.getImage() == slot3.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			selected.remove(10);
			slot3.setImage(null);
			slots[2] = false;
		}
	}

	@FXML
	private void slot2Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot2.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			selected.remove(0);
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op1.getImage() == slot2.getImage()) {
			op1.setOpacity(1);
			selected.remove(1);
			plants[1] = true;
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op2.getImage() == slot2.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(2);
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op3.getImage() == slot2.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			selected.remove(3);
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op4.getImage() == slot2.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			selected.remove(4);
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op5.getImage() == slot2.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			selected.remove(5);
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op6.getImage() == slot2.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			selected.remove(6);
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op7.getImage() == slot2.getImage()) {
			op7.setOpacity(1);
			plants[7] = true;
			selected.remove(7);
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op8.getImage() == slot2.getImage()) {
			op8.setOpacity(1);
			plants[8] = true;
			selected.remove(8);
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op9.getImage() == slot2.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			selected.remove(9);
			slot2.setImage(null);
			slots[1] = false;
		}
		else if (op10.getImage() == slot2.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			selected.remove(10);
			slot2.setImage(null);
			slots[1] = false;
		}
	}

	@FXML
	private void slot1Click(MouseEvent mouseEvent) {
		if(op0.getImage() == slot1.getImage()) {
			op0.setOpacity(1);
			plants[0] = true;
			slot1.setImage(null);
			selected.remove(0);
			slots[0] = false;
		}
		else if (op1.getImage() == slot1.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(1);
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op2.getImage() == slot1.getImage()) {
			op1.setOpacity(1);
			plants[1] = true;
			selected.remove(2);
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op3.getImage() == slot1.getImage()) {
			op3.setOpacity(1);
			plants[3] = true;
			selected.remove(3);
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op4.getImage() == slot1.getImage()) {
			op4.setOpacity(1);
			plants[4] = true;
			slot1.setImage(null);
			selected.remove(4);
			slots[0] = false;
		}
		else if (op5.getImage() == slot1.getImage()) {
			op5.setOpacity(1);
			plants[5] = true;
			selected.remove(5);
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op6.getImage() == slot1.getImage()) {
			op6.setOpacity(1);
			plants[6] = true;
			slot1.setImage(null);
			selected.remove(6);
			slots[0] = false;
		}
		else if (op7.getImage() == slot1.getImage()) {
			op7.setOpacity(1);
			selected.remove(7);
			plants[7] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op8.getImage() == slot1.getImage()) {
			op8.setOpacity(1);
			selected.remove(8);
			plants[8] = true;
			slot1.setImage(null);
			slots[0] = false;
		}
		else if (op9.getImage() == slot1.getImage()) {
			op9.setOpacity(1);
			plants[9] = true;
			slot1.setImage(null);
			selected.remove(9);
			slots[0] = false;
		}
		else if (op10.getImage() == slot1.getImage()) {
			op10.setOpacity(1);
			plants[10] = true;
			selected.remove(10);
			slot1.setImage(null);
			slots[0] = false;
		}
	}
}
