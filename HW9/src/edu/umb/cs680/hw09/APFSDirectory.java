package edu.umb.cs680.hw09;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFSDirectory extends APFSElement{

    private LinkedList<APFSElement> child;



    public APFSDirectory(APFSDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModified) {
        super(parent, name, size, creationTime, ownerName, lastModified);
        if(parent != null)
            parent.appendChild(this);
    }
    public LinkedList<APFSFile> getFiles() {
        LinkedList<APFSFile> listfile = new LinkedList<APFSFile>();
        for(FSElement s : getChildren()) {
            if(s instanceof APFSFile)
                listfile.add((APFSFile) s);
        }
        return listfile;
    }
    @Override
    public boolean isDirectory() {
        return true;
    }
    public LinkedList<APFSElement> getChildren() {
        if(this.child == null) {
            this.child = new LinkedList<APFSElement>();
        }
        return child;
    }
    public LinkedList<APFSLink> getLinks() {
        LinkedList<APFSLink> listoflink = new LinkedList<APFSLink>();
        for(FSElement s : getChildren()) {
            if(s instanceof APFSLink)
                listoflink.add((APFSLink) s);
        }
        return listoflink;
    }

    public int getTotalSize() {
        int sizetotvalue = 0;
        for(APFSElement s : getChildren()) {
            if(s instanceof APFSDirectory)
                sizetotvalue += ((APFSDirectory) s).getTotalSize();
            else
                sizetotvalue += s.getSize();
        }
        return sizetotvalue;
    }
    public void appendChild(APFSElement child) {
        if(this.child == null) {
            this.child = new LinkedList<APFSElement>();
        }
        this.child.add(child);
    }

    public int countChildren() {
        return getChildren().size() - getLinks().size();
    }

    public LinkedList<APFSDirectory> getSubDirectories() {
        LinkedList<APFSDirectory> listdir = new LinkedList<APFSDirectory>();
        for(FSElement s : getChildren()) {
            if(s instanceof APFSDirectory)
                listdir.add((APFSDirectory) s);
        }
        return listdir;
    }




    public APFSLink findByName_Link(String nameoflink) {
        APFSLink link = null;
        for(APFSLink l : getLinks()) {
            if(nameoflink.equals(l.getName()))
                link = l;
        }
        if(link == null) {
            for(APFSDirectory dir : getSubDirectories()) {
                link = dir.findByName_Link(nameoflink);
                if(link != null)
                    break;
            }
        }
        return link;
    }
    public APFSDirectory findByName_Directory(String nameofdir) {
        APFSDirectory nameddirectory = null;
        if(nameofdir.equals(getName()))
            nameddirectory = this;
        else {
            for(APFSDirectory dir : getSubDirectories()) {
                if(nameddirectory == null) {
                    nameddirectory = dir.findByName_Directory(nameofdir);
                    if(nameofdir.equals(dir.getName())) {
                        nameddirectory = dir;
                        break;
                    }
                }
            }
        }
        return nameddirectory;
    }

    public APFSFile findByName_File(String namedfile) {
        APFSFile fileinstance = null;
        for(APFSFile f : getFiles()) {
            if(namedfile.equals(f.getName()))
                fileinstance = f;
        }
        if(fileinstance == null) {
            for(APFSDirectory dir : getSubDirectories()) {
                fileinstance = dir.findByName_File(namedfile);
                if(fileinstance != null)
                    break;
            }
        }
        return fileinstance;
    }



    public static void main(String[] args) {
        System.out.println("APFSDirectory run successfully");
    }
}