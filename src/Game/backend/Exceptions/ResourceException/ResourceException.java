package Game.backend.Exceptions.ResourceException;

import Game.backend.Exceptions.CustomException;

public abstract class ResourceException extends CustomException
{
	protected ResourceException(String message)
	{
		super(message);
	}
}
