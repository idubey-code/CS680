package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DVDPlayerTest {

    DVDPlayer player = DVDPlayer.getInstance();

    @Test
    public void drawerClosedNotPlayingTest(){

        player.openCloseButtonPushed();
        State actual = player.getState();
        State expected = DrawerOpen.getInstance();
        assertSame(expected,actual);

        player.changeState(DrawerClosedPlaying.getInstance());
        player.playButtonPushed();
        actual = player.getState();
        expected = DrawerClosedPlaying.getInstance();
        assertSame(expected,actual);

        player.changeState(DrawerClosedPlaying.getInstance());
        player.stopButtonPushed();
        actual = player.getState();
        expected = DrawerClosedNotPlaying.getInstance();
        assertSame(expected,actual);

    }

    @Test
    public void drawerClosedPlayingTest(){

        player.changeState(DrawerClosedPlaying.getInstance());
        player.openCloseButtonPushed();
        State actual = player.getState();
        State expected = DrawerOpen.getInstance();
        assertSame(expected,actual);

        player.changeState(DrawerClosedPlaying.getInstance());
        player.playButtonPushed();
        actual = player.getState();
        expected = DrawerClosedPlaying.getInstance();
        assertSame(expected,actual);

        player.stopButtonPushed();
        actual = player.getState();
        expected = DrawerClosedNotPlaying.getInstance();
        assertSame(expected,actual);

    }

    @Test
    public void drawerOpenTest(){

        player.changeState(DrawerOpen.getInstance());
        player.openCloseButtonPushed();
        State actual = player.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertSame(expected,actual);

        player.changeState(DrawerOpen.getInstance());
        player.playButtonPushed();
        actual = player.getState();
        expected = DrawerClosedPlaying.getInstance();
        assertSame(expected,actual);

        player.changeState(DrawerOpen.getInstance());
        player.stopButtonPushed();
        actual = player.getState();
        expected = DrawerOpen.getInstance();
        assertSame(expected,actual);

    }


}