package Game.backend.Exceptions;

public final class UsernameExistsException extends CustomException
{
	public UsernameExistsException(String message)
	{
		super(message);
	}
}
