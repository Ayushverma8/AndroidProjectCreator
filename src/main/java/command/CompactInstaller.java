/*
 * Copyright (C) 2020 Max 'Libra' Kersten
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package command;

import apc.RepositoryManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import library.Constants;
import model.Repository;

/**
 * Handles the compact installation of all required tools for
 * AndroidProjectCreator.
 *
 * @author Max 'Libra' Kersten
 */
public class CompactInstaller {

    /**
     * Performs the compact installation of the required tools by cloning a
     * repository directly into the library folder
     */
    public void install() throws IOException, InterruptedException, Exception {
        System.out.println("[+]Starting the installation");
        AtomicReference<RepositoryManager> repositoryManager =new AtomicReference<>(new RepositoryManager());
        System.out.println("[+]Starting cloning the repositories");
        List<Repository> repository = new ArrayList<>();
        String name = "CompactInstall version 1.1 (dated 11-05-2021)";
        String url = "https://github.com/thisislibra/apc-compact.git";
        File directory = new File(Constants.LIBRARY_FOLDER);
        String branch = "11-05-2021";
        repository.add(new Repository(name, url, directory, branch));
        repositoryManager.get().cloneRepositories(repository);
        System.out.println("[+]Cloning finished");
        System.out.println("[+]Verifying the toolset");
        repositoryManager.get().verifyInstallationUsingRequiredFolders();
        System.out.println("[+]Verification succesful!");
        System.out.println("[+]Installation complete!");
    }
}
