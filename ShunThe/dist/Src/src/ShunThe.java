import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
*
* @author Nijiko
*/
public class ShunThe extends Plugin  {
	private Listener l = new Listener(this);
	protected static final Logger log = Logger.getLogger("Minecraft");
	private String name = "ShunThe";
	private String version = "1.0";

	public void enable() {
	}

	public void disable() {
	}

	public void initialize() {
		log.info(name + " " + version + " initialized");
		// Uncomment as needed.
		//etc.getLoader().addListener( PluginLoader.Hook.ARM_SWING, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.BLOCK_CREATED, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.BLOCK_DESTROYED, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.CHAT, l, this, PluginListener.Priority.MEDIUM);
		etc.getLoader().addListener( PluginLoader.Hook.COMMAND, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.COMPLEX_BLOCK_CHANGE, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.COMPLEX_BLOCK_SEND, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.DISCONNECT, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.INVENTORY_CHANGE, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.IPBAN, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.KICK, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.LOGIN, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.LOGINCHECK, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.NUM_HOOKS, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.PLAYER_MOVE, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.SERVERCOMMAND, l, this, PluginListener.Priority.MEDIUM);
		//etc.getLoader().addListener( PluginLoader.Hook.TELEPORT, l, this, PluginListener.Priority.MEDIUM);
	}

	// Sends a message to all players!
	public void broadcast(String message) {
		for (Player p : etc.getServer().getPlayerList()) {
			p.sendMessage(message);
		}
	}

	public class Listener extends PluginListener {
		ShunThe p;

		// This controls the accessability of functions / variables from the main class.
		public Listener(ShunThe plugin) {
			p = plugin;
		}

		// remove the /* and */ from any function you want to use
		// make sure you add them to the listener above as well!

		/*
		public void onPlayerMove(Player player, Location from, Location to) {
		}
		*/

		/*
		public boolean onTeleport(Player player, Location from, Location to) {
			return false;
		}
		*/

		/*
		public String onLoginChecks(String user) {
			return null;
		}
		*/

                /*
		public void onLogin(Player player) {
			// Player Message
			player.sendMessage(Colors.Yellow + "Currently running plugin: " + p.name + " v" + p.version + "!");

			// Global Message
			p.broadcast(Colors.Green + player.getName() + " has joined the server! Wooo~");
		}
                */
		/*
		public void onDisconnect(Player player) {		public void onLogin(Player player) {
			// Player Message
			player.sendMessage(Colors.Yellow + "Currently running plugin: " + p.name + " v" + p.version + "!");

			// Global Message
			p.broadcast(Colors.Green + player.getName() + " has joined the server! Wooo~");
		}
		*/

		/*
		public boolean onChat(Player player, String message) {
			return false;
		}
		*/

		
        @Override
		public boolean onCommand(Player player, String[] split) {
                    if(split[0].equals("/shun") && player.canUseCommand("/shun")){
                        if(split[1] != null){
                            Random rand = new Random();
                            Server s = etc.getServer();
                            Player ply = s.getPlayer(split[1]);
                            ply.sendMessage("You Have Benn Shuned By " + player.getName());
                            p.broadcast(ply.getName() + " Has Benn Shuned By " + player.getName() + " To the Outskirts of the world.");
                            Location Loca = new Location(s.getSpawnLocation().x - ( rand.nextDouble() * s.getSpawnLocation().y ),s.getSpawnLocation().y - ( rand.nextDouble() * s.getSpawnLocation().x ),s.getSpawnLocation().z + 25.0);
                            ply.teleportTo(Loca);
                            ply.setPrefix("Trator");
                            p.broadcast(ply.getName() + " is now at " + Loca.toString());
                            p.log.log(Level.INFO, "Atempting to Wipe " + ply.getName() + "'s invintory");
                            ply.sendMessage("Wipeing your invintory");
                            Inventory inv = ply.getInventory();
                            for(int i = 0; i > inv.getArray().length + 1; i++){

                                inv.removeItem(i);
                            }
                            inv.updateInventory();
                            ply.sendMessage("You Have Now Benn Sanitized");
                            p.broadcast(ply.getName() +" Has Benn Sucsessfuly Suned and Sanitized");
                        }
                    }
			return false;
		}
		

		/*
		public boolean onConsoleCommand(String[] split) {
			return false;
		}
		*/

		/*
		public void onBan(Player mod, Player player, String reason) {
		}
		*/

		/*
		public void onIpBan(Player mod, Player player, String reason) {
		}
		*/

		/*
		public void onKick(Player mod, Player player, String reason) {
		}
		*/

		/*
		public boolean onBlockCreate(Player player, Block blockPlaced, Block blockClicked, int itemInHand) {
			return false;
		}
		*/

		/*
		public boolean onBlockDestroy(Player player, Block block) {
			return false;
		}
		*/

		/*
		public void onArmSwing(Player player) {
		}
		*/

		/*
		public boolean onInventoryChange(Player player) {
			return false;
		}
		*/

		/*
		public boolean onComplexBlockChange(Player player, ComplexBlock block) {
			return false;
		}
		*/

		/*
		public boolean onSendComplexBlock(Player player, ComplexBlock block) {
			return false;
		}
		*/
	}
}
