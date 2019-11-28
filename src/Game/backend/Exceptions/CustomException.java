package Game.backend.Exceptions;

public abstract class CustomException extends Exception
{
	protected CustomException(String message)
	{
		super(message);
	}
}
