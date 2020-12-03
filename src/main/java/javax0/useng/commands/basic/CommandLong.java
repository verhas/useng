package javax0.useng.commands.basic;

import javax0.useng.api.CommandContext;
import javax0.useng.api.CommandResult;
import javax0.useng.api.NamedCommand;
import javax0.useng.commands.TextArgumentManager;

import java.util.List;

public class CommandLong implements NamedCommand<Long> {

    public ArgumentManager argumentManager() {
        return TextArgumentManager.INSTANCE;
    }

    @Override
    public CommandResult<Long> evaluate(CommandContext ctx, List<CommandResult<?>> results) {
        final var result = results.get(0);
        if (result.type() == Long.class) {
            return (CommandResult<Long>) result;
        }
        if (result.type() == String.class) {
            final var d = Long.parseLong((String) result.get());
            return CommandResult.simple(d, Long.class);
        }
        return CommandResult.simple((Long) result.get(), Long.class);
    }

    @Override
    public String name() {
        return "Long";
    }
}