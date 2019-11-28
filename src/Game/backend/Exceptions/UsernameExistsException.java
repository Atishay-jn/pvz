package Game.backend.Exceptions;

public final class UsernameExistsException extends CustomException
{
	protected UsernameExistsException(String message)
	{
		super(message);
	}
}
