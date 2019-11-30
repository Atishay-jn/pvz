package Game.backend.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public abstract class SaveGame extends CurrentUser
{
	public static void serialize() throws IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserFiles/" + user.getName() + "/userdata.txt")))
		{
			out.writeObject(user);
		}
	}
}
