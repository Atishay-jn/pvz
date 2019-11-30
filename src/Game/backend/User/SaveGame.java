package Game.backend.User;

import java.io.*;

public abstract class SaveGame extends CurrentUser
{
	public static void serialize() throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("UserFiles/"+user.getName()+"/"+"userdata.text"));
			out.writeObject(user);
		}
		finally
		{
			out.close();
		}
	}
}
