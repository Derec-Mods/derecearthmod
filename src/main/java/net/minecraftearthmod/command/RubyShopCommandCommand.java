
package net.minecraftearthmod.command;

@Mod.EventBusSubscriber public class RubyShopCommandCommand {

	@SubscribeEvent public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("shop")
			.requires(s -> s.hasPermission(3))
			.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
    ServerLevel world = arguments.getSource().getLevel();

    double x = arguments.getSource().getPosition().x();
    double y = arguments.getSource().getPosition().y();
    double z = arguments.getSource().getPosition().z();

    Entity entity = arguments.getSource().getEntity();
    if (entity == null)
        entity = FakePlayerFactory.getMinecraft(world);

    Direction direction = entity.getDirection();

    HashMap<String, String> cmdparams = new HashMap<>();
    int index = -1;
    for (String param : arguments.getInput().split("\\s+")) {
        if (index >= 0)
            cmdparams.put(Integer.toString(index), param);
        index++;
    }

    

    RubyShopCommandCommandExecutedProcedure.execute(world,x,y,z,entity)
;
    return 0;
}))
.executes(arguments -> {
    ServerLevel world = arguments.getSource().getLevel();

    double x = arguments.getSource().getPosition().x();
    double y = arguments.getSource().getPosition().y();
    double z = arguments.getSource().getPosition().z();

    Entity entity = arguments.getSource().getEntity();
    if (entity == null)
        entity = FakePlayerFactory.getMinecraft(world);

    Direction direction = entity.getDirection();

    HashMap<String, String> cmdparams = new HashMap<>();
    int index = -1;
    for (String param : arguments.getInput().split("\\s+")) {
        if (index >= 0)
            cmdparams.put(Integer.toString(index), param);
        index++;
    }

    

    RubyShopCommandCommandExecutedProcedure.execute(world,x,y,z,entity)
;
    return 0;
})
		);
	}

}
