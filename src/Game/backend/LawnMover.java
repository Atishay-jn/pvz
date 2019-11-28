package Game.backend;

public final class LawnMover implements Displayable
{
	private int position;

	public LawnMover(int _position)
	{
		this.position = _position;
	}

	public void update()
	{
		this.position += 5;
		if(this.position >= 500)
			this.position = 500;
	}

	public int getPosition()
	{
		return position;
	}

	@Override
	public String getImage()
	{
		return null;
	}
}
